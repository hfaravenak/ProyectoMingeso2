package cl.usach.mingeso.laboratorioservice.Controller;

import cl.usach.mingeso.laboratorioservice.Entity.LaboratorioEntity;
import cl.usach.mingeso.laboratorioservice.Service.LaboratorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {
    @Autowired
    LaboratorioService laboratorioService;

    @GetMapping("/fileUpload")
    public String main() { return "lab-file-upload"; }

    @PostMapping("/fileUpload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        laboratorioService.guardarArchivo(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        laboratorioService.leerCsv("Laboratorio.csv");
        return "redirect:/laboratorio/fileUpload";
    }

    @GetMapping("/fileInformation")
    public String listar(Model model) {
        List<LaboratorioEntity> datas = laboratorioService.obtenerDataLab();
        model.addAttribute("datas", datas);
        return "lab-file-information";
    }
}
