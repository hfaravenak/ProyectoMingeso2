package cl.usach.mingeso.planillaservice.Controller;

import cl.usach.mingeso.planillaservice.Entity.PlanillaEntity;
import cl.usach.mingeso.planillaservice.Models.AcopioModel;
import cl.usach.mingeso.planillaservice.Models.LaboratorioModel;
import cl.usach.mingeso.planillaservice.Models.ProveedorModel;
import cl.usach.mingeso.planillaservice.Models.QuincenaModel;
import cl.usach.mingeso.planillaservice.Repository.PlanillaRepository;
import cl.usach.mingeso.planillaservice.Service.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/planilla")
public class PlanillaController {
    @Autowired
    PlanillaService planillaService;

    @PostMapping
    public ResponseEntity<PlanillaEntity> crearNuevaQuincena(@RequestParam("proveedorId") String porveedorId){
        PlanillaEntity nuevaPlanilla = planillaService.crearPlanilla(porveedorId);
        return ResponseEntity.ok(nuevaPlanilla);
    }

    @GetMapping("/listar-planillas")
    public ResponseEntity<List<PlanillaEntity>> listarPlanillas(){
        List<PlanillaEntity> planillas = planillaService.obtenerPlanillas();
        if(planillas.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(planillas);
    }

    @GetMapping("/{codigoProveedor}")
    public ResponseEntity<List<PlanillaEntity>> getByProveedorId(@PathVariable("codigoProveedor") String proveedorId){
        List<PlanillaEntity> planilla = planillaService.getPorIdProveedor(proveedorId);
        return ResponseEntity.ok(planilla);
    }


    //TESTINGS DE METODOS

    @GetMapping("/obtener-proveedor/{proveedorId}")
    public ProveedorModel obtenerProveedorPorId(@PathVariable String proveedorId) {
        return planillaService.consultaProveedor(proveedorId);
    }

    @GetMapping("/obtener-acopio/{proveedorId}")
    public List<AcopioModel> obtenerAcopioPorProveedor(@PathVariable String proveedorId) {
        return planillaService.consultaAcopio(proveedorId);
    }

    @GetMapping("/obtener-lab/{proveedorId}")
    public List<LaboratorioModel> obtenerLabPorProveedor(@PathVariable String proveedorId) {
        return planillaService.consultaLaboratorio(proveedorId);
    }

    @GetMapping("/obtener-quincena/{proveedorId}")
    public List<QuincenaModel> obtenerQuincenaPorProveedor(@PathVariable String proveedorId) {
        return planillaService.consultaQuincena(proveedorId);
    }

    //TESTINGS!!!!!!!!!!!!!!

    //METODO PARA OBTENER LA FECHA CONCATENADA CON LA QUINCENA EN EL FORMATO SOLICITADO EN EL ENUNCIADO
    //(AAA/MM/Q)
    @GetMapping("obtener-numeroquincena/{codigo}")
    public String obtenerNumeroQuincena(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerQuincena(codigo);
    }

    @GetMapping("obtener-nombreProveedor/{codigo}")
    public String obtenerNombreProveedor(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerNombreProveedor(codigo);
    }

    @GetMapping("obtener-kilosporproveedor/{codigo}")
    public Double obtenerKilosProveedor(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerKilosPorProveedor(codigo);
    }

    @GetMapping("obtener-diasQueEnvioLeche/{codigo}")
    public Integer obtenerDias(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerNroDiasQueEnvioLeche(codigo);
    }

    @GetMapping("obtener-variacionKilosLeche/{codigo}")
    public Double obtenerVariacionKilosLecheProveedor(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerVariacionLeche(codigo);
    }

    @GetMapping("obtener-grasa/{codigo}")
    public Double obtenerPorcentajeGrasaPorProveedor(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerPorcentajeGrasaLaboratorio(codigo);
    }

    @GetMapping("obtener-categoria/{codigo}")
    public String obtenerCategoriaProveedor(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerCategoriaProveedor(codigo);
    }

    @GetMapping("obtener-diasAcopioM/{codigo}")
    public Integer obtenerDiasAcopioM(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerDiasAcopioM(codigo);
    }

    @GetMapping("obtener-diasAcopioT/{codigo}")
    public Integer obtenerDiasAcopioT(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerDiasAcopioT(codigo);
    }

    @GetMapping("obtener-diasAcopioMyT/{codigo}")
    public Integer obtenerDiasAcopioMyT(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerDiasAcopioMyT(codigo);
    }

    @GetMapping("obtener-retencion/{codigo}")
    public String obtenerRetencionProveedor(@PathVariable("codigo") String codigo) {
        return planillaService.obtenerRetencionString(codigo);
    }



}
