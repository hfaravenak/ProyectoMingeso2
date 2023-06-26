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
    public List<ProveedorEntity> obtenerProveedores(){ return proveedorService.obtenerProveedores(); }

    @PostMapping("/crear-proveedor")
    public void crearProveedor(@RequestBody ProveedorEntity proveedor) {
        proveedorService.guardarProveedor(proveedor.getCodigo(), proveedor.getNombre(), proveedor.getCategoria(), proveedor.getRetencion());
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
