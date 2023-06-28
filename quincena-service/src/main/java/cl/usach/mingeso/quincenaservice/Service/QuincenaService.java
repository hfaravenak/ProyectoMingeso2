package cl.usach.mingeso.quincenaservice.Service;

import cl.usach.mingeso.quincenaservice.Entity.QuincenaEntity;
import cl.usach.mingeso.quincenaservice.Models.AcopioModel;
import cl.usach.mingeso.quincenaservice.Models.LaboratorioModel;
import cl.usach.mingeso.quincenaservice.Models.ProveedorModel;
import cl.usach.mingeso.quincenaservice.Repository.QuincenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class QuincenaService {
    @Autowired
    QuincenaRepository quincenaRepository;
    @Autowired
    RestTemplate restTemplate;

    public List<QuincenaEntity> obtenerQuincenas(){ return quincenaRepository.findAll(); }

    public List<QuincenaEntity> getPorIdProveedor(String proveedorId){
        return quincenaRepository.findByCodigoProveedor(proveedorId);
    }

    public QuincenaEntity guardarQuincena(QuincenaEntity quincenaEntity) {
        QuincenaEntity nuevaQuincena = quincenaRepository.save(quincenaEntity);
        return nuevaQuincena;
    }

    public ProveedorModel consultaProveedor(String proveedorId){
        ProveedorModel datosProveedor = restTemplate.getForObject("http://proveedor-service/proveedor/obtener-proveedor/"+proveedorId,ProveedorModel.class);
        return datosProveedor;
    }

    public List<AcopioModel> consultaAcopio(String proveedorId){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<AcopioModel>> response = restTemplate.exchange("http://acopio-service/acopio/" + proveedorId, HttpMethod.GET, entity, new ParameterizedTypeReference<List<AcopioModel>>() {});

        List<AcopioModel> acopio = response.getBody();
        return acopio;
    }

    public List<LaboratorioModel> consultaLaboratorio(String proveedorId){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<LaboratorioModel>> response = restTemplate.exchange("http://laboratorio-service/laboratorio/" + proveedorId, HttpMethod.GET, entity, new ParameterizedTypeReference<List<LaboratorioModel>>() {});

        List<LaboratorioModel> laboratorio = response.getBody();
        return laboratorio;
    }



    //metodo para convertir un string a date
    public Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.parse(dateString);
    }

    //metodo que retorna 1 si la fecha es la primera quincena y 2 si es la segunda quincena de un mes
    public int obtenerNumeroQuincena(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        if (dia <= 15) {
            return 1; // Primera quincena
        } else {
            return 2; // Segunda quincena
        }
    }

    //a traves del codigo de un proveedor obtiene los kilos leche de sus acopios
    public Double obtenerKilosLechePorProveedor(String proveedorId) {
        List<AcopioModel> acopios = consultaAcopio(proveedorId);
        Double kilosLeche = 0.0;

        for (AcopioModel acopio : acopios) {
            kilosLeche += Double.valueOf(acopio.getKls_leche());
        }

        return kilosLeche;
    }

    //a traves del codigo de un proveedor obtiene la fecha de su primer acopio
    public Date obtenerFechaAcopioPorProveedor(String proveedorId) {
        List<AcopioModel> acopios = consultaAcopio(proveedorId);

        if (!acopios.isEmpty()) {
            AcopioModel primerAcopio = acopios.get(0);
            String fechaString = primerAcopio.getFecha(); // Obtener la fecha como String
            try {
                return convertStringToDate(fechaString); // Convertir el String a un objeto Date
            } catch (ParseException e) {
                // Manejar la excepción en caso de error al convertir la fecha
                e.printStackTrace();
            }
        }

        return null; // Si no se encontraron acopios para el proveedorId o hubo un error al convertir la fecha
    }

    public Double obtenerPorcentajeGrasaLaboratorio(String proveedorId) {
        List<LaboratorioModel> laboratorios = consultaLaboratorio(proveedorId);

        if (!laboratorios.isEmpty()) {
            LaboratorioModel primerLaboratorio = laboratorios.get(0);
            return primerLaboratorio.getPorcentajeGrasa();
        }

        return null; // Si no se encontraron laboratorios para el proveedorId
    }

    public Double obtenerPorcentajeSolidosLaboratorio(String proveedorId) {
        List<LaboratorioModel> laboratorios = consultaLaboratorio(proveedorId);

        if (!laboratorios.isEmpty()) {
            LaboratorioModel primerLaboratorio = laboratorios.get(0);
            return primerLaboratorio.getPorcSolidosTotales();
        }

        return null; // Si no se encontraron laboratorios para el proveedorId
    }

    //obtiene los dias que de mañana un proveeodor envio leche a un acopio
    public int contarDiasAcopiom(String codigoProveedor) {
        List<AcopioModel> acopios = consultaAcopio(codigoProveedor);
        int diasAcopiom = 0;

        for (AcopioModel acopio : acopios) {
            String turno = acopio.getTurno();
            if (turno != null && turno.equalsIgnoreCase("M")) {
                diasAcopiom++;
            }
        }

        return diasAcopiom;
    }

    //obtiene los dias que de tarde un proveeodor envio leche a un acopio
    public int contarDiasAcopiot(String codigoProveedor) {
        List<AcopioModel> acopios = consultaAcopio(codigoProveedor);
        int diasAcopiot = 0;

        for (AcopioModel acopio : acopios) {
            String turno = acopio.getTurno();
            if (turno != null && turno.equalsIgnoreCase("T")) {
                diasAcopiot++;
            }
        }

        return diasAcopiot;
    }

    public int contarDiasAcopiomt(String codigoProveedor) {
        List<AcopioModel> acopios = consultaAcopio(codigoProveedor);
        int contadorDiasAcopio = 0;

        Map<String, Set<String>> fechaTurnoMap = new HashMap<>();
        for (AcopioModel acopio : acopios) {
            String fecha = acopio.getFecha();
            String turno = acopio.getTurno();

            if (fecha != null && turno != null && (turno.equalsIgnoreCase("M") || turno.equalsIgnoreCase("T"))) {
                Set<String> turnos = fechaTurnoMap.getOrDefault(fecha, new HashSet<>());
                turnos.add(turno);
                fechaTurnoMap.put(fecha, turnos);
            }
        }

        for (Set<String> turnos : fechaTurnoMap.values()) {
            if (turnos.contains("M") && turnos.contains("T")) {
                contadorDiasAcopio++;
            }
        }

        return contadorDiasAcopio;
    }

    public String obtenerNombreProveedor(String proveedorId) {
        ProveedorModel proveedor = consultaProveedor(proveedorId);
        if (proveedor != null) {
            return proveedor.getNombre();
        }
        return null; // o puedes retornar un valor predeterminado si no se encuentra el proveedor
    }

    public String obtenerCategoriaProveedor(String proveedorId) {
        ProveedorModel proveedor = consultaProveedor(proveedorId);
        if (proveedor != null) {
            return proveedor.getCategoria();
        }
        return null; // o puedes retornar un valor predeterminado si no se encuentra el proveedor
    }

    public String obtenerRetencionProveedor(String proveedorId) {
        ProveedorModel proveedor = consultaProveedor(proveedorId);
        if (proveedor != null) {
            return proveedor.getRetencion();
        }
        return null; // o puedes retornar un valor predeterminado si no se encuentra el proveedor
    }

    public QuincenaEntity crearQuincena(String proveedorId) {
        // Obtener nombre proveedor
        String nombreProveedor = obtenerNombreProveedor(proveedorId);

        String categoriaProveedor = obtenerCategoriaProveedor(proveedorId);

        String retencionProveedor = obtenerRetencionProveedor(proveedorId);

        // Obtener kilos de leche del proveedor
        double totalKilosLeche = obtenerKilosLechePorProveedor(proveedorId);

        // Obtener fecha del primer acopio del proveedor
        Date fechaAcopio = obtenerFechaAcopioPorProveedor(proveedorId);

        // Obtener número de quincena
        int numeroQuincena = obtenerNumeroQuincena(fechaAcopio);

        // Obtener porcentaje total de grasa del laboratorio del proveedor
        double totalPorcentajeGrasaLaboratorio = obtenerPorcentajeGrasaLaboratorio(proveedorId);

        // Obtener porcentaje total de sólidos totales del laboratorio del proveedor
        double totalPorcentajeSolidosTotalesLaboratorio = obtenerPorcentajeSolidosLaboratorio(proveedorId);

        // Contar días de mañana (M) en los acopios del proveedor
        int diasAcopiom = contarDiasAcopiom(proveedorId);

        // Contar días de tarde (T) en los acopios del proveedor
        int diasAcopiot = contarDiasAcopiot(proveedorId);

        // Contar días de mañana (M) y tarde (T) en los acopios del proveedor
        int diasAcopiomt = contarDiasAcopiomt(proveedorId);

        // Crear nueva quincena
        QuincenaEntity nuevaQuincena = new QuincenaEntity();
        nuevaQuincena.setCodigoProveedor(proveedorId);
        nuevaQuincena.setNombreProveedor(nombreProveedor);
        nuevaQuincena.setCategoriaProveedor(categoriaProveedor);
        nuevaQuincena.setRetencionProveedor(retencionProveedor);
        nuevaQuincena.setKilos(totalKilosLeche);
        nuevaQuincena.setFecha(fechaAcopio);
        nuevaQuincena.setQuincena(numeroQuincena);
        nuevaQuincena.setPorcentajeGrasa(totalPorcentajeGrasaLaboratorio);
        nuevaQuincena.setPorcentajeSolidosTotales(totalPorcentajeSolidosTotalesLaboratorio);
        nuevaQuincena.setDiasAcopioM(diasAcopiom);
        nuevaQuincena.setDiasAcopioT(diasAcopiot);
        nuevaQuincena.setDiasAcopioMT(diasAcopiomt);

        return quincenaRepository.save(nuevaQuincena);
    }


}
