package cl.usach.mingeso.acopioservice.Service;

import cl.usach.mingeso.acopioservice.Entity.AcopioEntity;
import cl.usach.mingeso.acopioservice.Repository.AcopioRepository;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class AcopioService {
    @Autowired
    AcopioRepository acopioRepository;

    private final Logger logg = LoggerFactory.getLogger(AcopioService.class);
    public List<AcopioEntity> obtenerAcopios() { return acopioRepository.findAll(); }

    public List<AcopioEntity> getPorIdProveedor(String proveedorId){
        return acopioRepository.findByProveedor(proveedorId);
    }

    public AcopioEntity guardarDatosAcopios(AcopioEntity acopio) { return acopioRepository.save(acopio); }

    public void eliminarAcopio(String proveedor) {
        List<AcopioEntity> acopios = acopioRepository.findByProveedor(proveedor);
        acopioRepository.deleteAll(acopios);
        logg.info("Se han eliminado " + acopios.size() + " acopios con proveedor: " + proveedor);
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
    public void leerCsv(String direccion){
        String texto = "";
        BufferedReader bf = null;
        acopioRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public void guardarDataDB(String fecha, String turno, String proveedor, String kls_leche){
        AcopioEntity newData = new AcopioEntity();
        newData.setFecha(fecha);
        newData.setTurno(turno);
        newData.setProveedor(proveedor);
        newData.setKls_leche(kls_leche);
        guardarDatosAcopios(newData);
    }

}
