package cl.usach.mingeso.planillaservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuincenaModel {
    private String quincena;
    private Date fecha;
    private String nombreProveedor;
    private String codigoProveedor;
    private String categoriaProveedor;
    private String retencionProveedor;
    private Double kilos;
    private Integer diasAcopioMT;
    private Integer diasAcopioM;
    private Integer diasAcopioT;
    private Double porcentajeGrasa;
    private Double porcentajeSolidosTotales;

}
