package cl.usach.mingeso.quincenaservice.Repository;

import cl.usach.mingeso.quincenaservice.Entity.QuincenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuincenaRepository extends JpaRepository<QuincenaEntity, Integer> {

    List<QuincenaEntity> findByCodigoProveedor(String proveedor);

}
