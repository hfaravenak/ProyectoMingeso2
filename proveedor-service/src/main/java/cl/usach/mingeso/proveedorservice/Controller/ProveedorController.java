package cl.usach.mingeso.proveedorservice.Controller;

import cl.usach.mingeso.proveedorservice.Entity.ProveedorEntity;
import cl.usach.mingeso.proveedorservice.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/listar-proveedores")
    public ResponseEntity<List<ProveedorEntity>> obtenerProveedores(){
        List<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        if(proveedores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(proveedores);
    }

    @PostMapping("/crear-proveedor")
    public ResponseEntity<ProveedorEntity> crearProveedor(@RequestBody ProveedorEntity proveedorEntity){
        ProveedorEntity nuevoProveedor = proveedorService.guardarProveedor(proveedorEntity);
        return ResponseEntity.ok(nuevoProveedor);
    }

    @DeleteMapping("/eliminar-proveedor/{codigo}")
    public void eliminarProveedor(@PathVariable String codigo) {
        proveedorService.eliminarProveedor(codigo);
    }

    @GetMapping("/obtener-proveedor/{codigo}")
    public ResponseEntity<ProveedorEntity> getById(@PathVariable("codigo") String proveedorId){
        ProveedorEntity proveedor = proveedorService.getProveedorPorCodigo(proveedorId);
        return ResponseEntity.ok(proveedor);
    }

}
