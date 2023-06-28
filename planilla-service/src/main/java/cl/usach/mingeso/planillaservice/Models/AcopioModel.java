package cl.usach.mingeso.planillaservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcopioModel {
    private String fecha;
    private String turno;
    private String kls_leche;
}
