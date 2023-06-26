package cl.usach.mingeso.planillaservice.Service;

import cl.usach.mingeso.planillaservice.Repository.PlanillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanillaService {
    @Autowired
    private PlanillaRepository planillaRepository;


}
