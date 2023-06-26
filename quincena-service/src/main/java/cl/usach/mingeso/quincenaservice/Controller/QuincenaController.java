package cl.usach.mingeso.quincenaservice.Controller;

import cl.usach.mingeso.quincenaservice.Entity.QuincenaEntity;
import cl.usach.mingeso.quincenaservice.Models.AcopioModel;
import cl.usach.mingeso.quincenaservice.Models.LaboratorioModel;
import cl.usach.mingeso.quincenaservice.Models.ProveedorModel;
import cl.usach.mingeso.quincenaservice.Repository.QuincenaRepository;
import cl.usach.mingeso.quincenaservice.Service.QuincenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/quincena")
public class QuincenaController {
    @Autowired
    QuincenaService quincenaService;

    @GetMapping("/listar-quincenas")
    public ResponseEntity<List<QuincenaEntity>> listarQuincenas(){
        List<QuincenaEntity> quincenas = quincenaService.obtenerQuincenas();
        if(quincenas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(quincenas);
    }

    @GetMapping("/crear-quincena/{proveedorId}")
    public ResponseEntity<QuincenaEntity> crearNuevaQuincena(@PathVariable("proveedorId") String porveedorId){
        QuincenaEntity nuevaQuincena = quincenaService.crearQuincena(porveedorId);
        return ResponseEntity.ok(nuevaQuincena);
    }

    //TESTINGS DE METODOS
    @GetMapping("/{proveedorId}")
    public List<AcopioModel> obtenerAcopioPorProveedor(@PathVariable String proveedorId) {
        return quincenaService.consultaAcopio(proveedorId);
    }

    @GetMapping("/obtener-proveedor/{proveedorId}")
    public ProveedorModel obtenerProveedorPorId(@PathVariable String proveedorId) {
        return quincenaService.consultaProveedor(proveedorId);
    }
    @GetMapping("/obtener-lab/{proveedorId}")
    public List<LaboratorioModel> obtenerLabPorProveedor(@PathVariable String proveedorId) {
        return quincenaService.consultaLaboratorio(proveedorId);
    }


    @GetMapping("/obtener-totalKlsLeche/{codigo}")
    public Double obtenerTodosKlsLeche(@PathVariable("codigo") String codigo) {
        return quincenaService.obtenerKilosLechePorProveedor(codigo);
    }

    @GetMapping("/obtenerFecha/{codigo}")
    public Date obtenerFecha(@PathVariable("codigo") String codigo) {
        return quincenaService.obtenerFechaAcopioPorProveedor(codigo);
    }

    @GetMapping("/obtenerGrasa/{codigo}")
    public Double obtenerGrasa(@PathVariable("codigo") String codigo) {
        return quincenaService.obtenerPorcentajeGrasaLaboratorio(codigo);
    }

    @GetMapping("/obtenerSolidos/{codigo}")
    public Double obtenerSolidos(@PathVariable("codigo") String codigo) {
        return quincenaService.obtenerPorcentajeSolidosLaboratorio(codigo);
    }

    @GetMapping("/contardiasm/{codigo}")
    public Integer contardiasm(@PathVariable("codigo") String codigo) {
        return quincenaService.contarDiasAcopiom(codigo);
    }

    @GetMapping("/contardiast/{codigo}")
    public Integer contardiast(@PathVariable("codigo") String codigo) {
        return quincenaService.contarDiasAcopiot(codigo);
    }
    @GetMapping("obtener-diasacopiomt/{codigo}")
    public Integer obtenerDiasAcopioMañanaYtarde(@PathVariable("codigo") String codigo) {
        return quincenaService.contarDiasAcopiomt(codigo);
    }


}
