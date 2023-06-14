package cl.usach.mingeso.laboratorioservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "laboratorio")
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)

    private Integer ID;
    private String proveedor;
    private Integer porcentajeGrasa;
    private Integer porcSolidosTotales;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(Integer porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public Integer getPorcSolidosTotales() {
        return porcSolidosTotales;
    }

    public void setPorcSolidosTotales(Integer porcSolidosTotales) {
        this.porcSolidosTotales = porcSolidosTotales;
    }
}

