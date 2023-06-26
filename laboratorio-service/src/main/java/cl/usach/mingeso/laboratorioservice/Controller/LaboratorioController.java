package cl.usach.mingeso.laboratorioservice.Controller;

import cl.usach.mingeso.laboratorioservice.Entity.LaboratorioEntity;
import cl.usach.mingeso.laboratorioservice.Service.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {
    @Autowired
    LaboratorioService laboratorioService;

    @PostMapping("/subir-lab")
    public String saveLab(@RequestParam("file") MultipartFile file){
        try{
            laboratorioService.guardarArchivo(file);
            laboratorioService.leerCsv(file.getOriginalFilename());
            return "Archivo importado correctamente";
        }catch (Exception e){
            return "Error" + e.getMessage();
        }
    }

    @GetMapping("/listar-labs")
    public ResponseEntity<List<LaboratorioEntity>> obtenerLaboratorios(){
        List<LaboratorioEntity> proveedores = laboratorioService.obtenerDataLab();
        if(proveedores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{codigoProveedor}")
    public ResponseEntity<List<LaboratorioEntity>> getByProveedorId(@PathVariable("codigoProveedor") String proveedorId){
        List<LaboratorioEntity> acopio = laboratorioService.getPorIdProveedor(proveedorId);
        return ResponseEntity.ok(acopio);
    }






}
