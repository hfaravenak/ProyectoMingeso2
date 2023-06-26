package cl.usach.mingeso.proveedorservice.Service;

import cl.usach.mingeso.proveedorservice.Entity.ProveedorEntity;
import cl.usach.mingeso.proveedorservice.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public List<ProveedorEntity> obtenerProveedores(){ return proveedorRepository.findAll(); }

    public void guardarProveedor(String codigo, String nombre, String categoria, String retencion){
        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setCodigo(codigo);
        proveedor.setNombre(nombre);
        proveedor.setCategoria(categoria);
        proveedor.setRetencion(retencion);
        proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(String codigo){
        ProveedorEntity proveedores = proveedorRepository.findByCodigo(codigo);
        proveedorRepository.delete(proveedores);
    }


}
