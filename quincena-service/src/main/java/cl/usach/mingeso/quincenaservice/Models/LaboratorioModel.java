package cl.usach.mingeso.quincenaservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorioModel {
    private Double porcentajeGrasa;
    private Double porcSolidosTotales;

    public Double getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(Double porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public Double getPorcSolidosTotales() {
        return porcSolidosTotales;
    }

    public void setPorcSolidosTotales(Double porcSolidosTotales) {
        this.porcSolidosTotales = porcSolidosTotales;
    }
}
