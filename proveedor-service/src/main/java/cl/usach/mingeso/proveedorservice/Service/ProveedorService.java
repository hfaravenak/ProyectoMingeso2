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

    public ProveedorEntity guardarProveedor(ProveedorEntity proveedorEntity){
        ProveedorEntity nuevoProveedor = proveedorRepository.save(proveedorEntity);
        return nuevoProveedor;
    }

    public void eliminarProveedor(String codigo){
        ProveedorEntity proveedores = proveedorRepository.findByCodigo(codigo);
        proveedorRepository.delete(proveedores);
    }

    public ProveedorEntity getProveedorPorCodigo(String codigo) { return proveedorRepository.findByCodigo(codigo); }

}
