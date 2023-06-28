package cl.usach.mingeso.planillaservice.Repository;

import cl.usach.mingeso.planillaservice.Entity.PlanillaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanillaRepository extends JpaRepository<PlanillaEntity, Integer> {
    List<PlanillaEntity> findByCodigoProveedor(String codigoProveedor);

}
