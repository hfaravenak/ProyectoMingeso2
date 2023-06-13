package cl.usach.mingeso.acopioservice.Controller;

import cl.usach.mingeso.acopioservice.Entity.AcopioEntity;
import cl.usach.mingeso.acopioservice.Service.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/acopio")
public class AcopioController {
    @Autowired
    AcopioService acopioService;

    @GetMapping("/fileUpload")
    public String main() {
        return "acopioFileUpload";
    }

    @PostMapping("/fileUpload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        acopioService.guardarArchivo(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo de Acopio cargado correctamente!");
        acopioService.leerCsv("Acopio.csv");
        return "redirect:/acopio/fileUpload";
    }

    @GetMapping("/fileInformation")
    public String listar(Model model) {
        List<AcopioEntity> datas = acopioService.obtenerAcopios();
        model.addAttribute("datas", datas);
        return "acopioFileInformation";
    }


}
