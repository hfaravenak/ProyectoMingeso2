package cl.usach.mingeso.acopioservice.Controller;

import cl.usach.mingeso.acopioservice.Entity.AcopioEntity;
import cl.usach.mingeso.acopioservice.Service.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/acopio")
public class AcopioController {
    @Autowired
    AcopioService acopioService;

    @PostMapping("/subir-acopio")
    public String save (@RequestParam("file") MultipartFile file){
        try{
            acopioService.guardarArchivo(file);
            acopioService.leerCsv(file.getOriginalFilename());
            return "Archivo importado correctamente";
        }catch (Exception e){
            return "Error" + e.getMessage();
        }
    }

    @GetMapping("/listar-acopios")
    public ResponseEntity<List<AcopioEntity>> obtenerProveedores(){
        List<AcopioEntity> proveedores = acopioService.obtenerAcopios();
        if(proveedores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{codigoProveedor}")
    public ResponseEntity<List<AcopioEntity>> getByProveedorId(@PathVariable("codigoProveedor") String proveedorId){
        List<AcopioEntity> acopio = acopioService.getPorIdProveedor(proveedorId);
        return ResponseEntity.ok(acopio);
    }


}
