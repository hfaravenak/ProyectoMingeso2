package cl.usach.mingeso.proveedorservice.Repository;

import cl.usach.mingeso.proveedorservice.Entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, String> {

    ProveedorEntity findByCodigo(String codigo);


}
