package cl.usach.mingeso.planillaservice.Controller;

import cl.usach.mingeso.planillaservice.Repository.PlanillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanillaController {
    @Autowired
    private PlanillaRepository planillaRepository;


}
