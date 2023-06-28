package cl.usach.mingeso.planillaservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorModel {
    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;


}
