package cl.usach.mingeso.proveedorservice.Controller;

import cl.usach.mingeso.proveedorservice.Entity.ProveedorEntity;
import cl.usach.mingeso.proveedorservice.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/listar-proveedores")
    public List<ProveedorEntity> obtenerProveedores(){ return proveedorService.obtenerProveedores(); }


}
