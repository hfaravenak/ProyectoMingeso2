package cl.usach.mingeso.laboratorioservice.Service;

import cl.usach.mingeso.laboratorioservice.Entity.LaboratorioEntity;
import cl.usach.mingeso.laboratorioservice.Repository.LaboratorioRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class LaboratorioService {
    @Autowired
    LaboratorioRepository laboratorioRepository;

    private final Logger logg = LoggerFactory.getLogger(LaboratorioService.class);

    public List<LaboratorioEntity> obtenerDataLab() { return laboratorioRepository.findAll(); }

    public List<LaboratorioEntity> getPorIdProveedor(String proveedorId){
        return laboratorioRepository.findByProveedor(proveedorId);
    }

    public LaboratorioEntity guardarDataLab(LaboratorioEntity laboratorio) { return laboratorioRepository.save(laboratorio); }

    public void eliminarLaboratorio(String proveedor) {
        List<LaboratorioEntity> laboratorios = laboratorioRepository.findByProveedor(proveedor);
        laboratorioRepository.deleteAll(laboratorios);
        logg.info("Se han eliminado " + laboratorios.size() + " laboratorios con proveedor: " + proveedor);
    }
    @Generated
    public String guardarArchivo(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsv(String direccion) {
        String texto = "";
        BufferedReader bf = null;
        laboratorioRepository.deleteAll();
        try {
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while ((bfRead = bf.readLine()) != null) {
                if (count == 1) {
                    count = 0;
                } else {
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        } catch (Exception e) {
            System.err.println("No se encontro el archivo");
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public void guardarDataDB(String proveedor, String porcentajeGrasa, String porcSolidosTotales){
        LaboratorioEntity newData = new LaboratorioEntity();
        newData.setProveedor(proveedor);
        Integer pGrasa =  Integer.parseInt(porcentajeGrasa);
        newData.setPorcentajeGrasa(pGrasa);
        Integer pSolidosTotales =  Integer.parseInt(porcSolidosTotales);
        newData.setPorcSolidosTotales(pSolidosTotales);
        guardarDataLab(newData);
    }


}
