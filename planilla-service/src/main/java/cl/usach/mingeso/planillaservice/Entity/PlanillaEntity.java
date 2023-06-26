package cl.usach.mingeso.planillaservice.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "planilla")
public class PlanillaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer ID;
    private String quincena;
    private String codigoProveedor;
    private String nombreProveedor;
    private Double totalKlsLeche;
    private Integer nroDiasEnvioLeche;
    private Double promedioDiarioKlsLeche;
    private Double porcentajeVariacionLeche;
    private Double porcentajeGrasa;
    private Double porcentajeVariacionGrasa;
    private Double porcentajeSolidosTotales;
    private Double porcentajeVariacionSolidosTotales;
    private Double pagoLeche;
    private Double pagoGrasa;
    private Double pagoSolidosTotales;
    private Double bonificacionFrecuencia;
    private Double dsctoVariacionLeche;
    private Double dsctoVariacionGrasa;
    private Double dsctoVariacionSolidosTotales;
    private Double pagoTotal;
    private Double montoRetencion;
    private Double montoFinal;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getQuincena() {
        return quincena;
    }

    public void setQuincena(String quincena) {
        this.quincena = quincena;
    }

    public String getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(String codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public Double getTotalKlsLeche() {
        return totalKlsLeche;
    }

    public void setTotalKlsLeche(Double totalKlsLeche) {
        this.totalKlsLeche = totalKlsLeche;
    }

    public Integer getNroDiasEnvioLeche() {
        return nroDiasEnvioLeche;
    }

    public void setNroDiasEnvioLeche(Integer nroDiasEnvioLeche) {
        this.nroDiasEnvioLeche = nroDiasEnvioLeche;
    }

    public Double getPromedioDiarioKlsLeche() {
        return promedioDiarioKlsLeche;
    }

    public void setPromedioDiarioKlsLeche(Double promedioDiarioKlsLeche) {
        this.promedioDiarioKlsLeche = promedioDiarioKlsLeche;
    }

    public Double getPorcentajeVariacionLeche() {
        return porcentajeVariacionLeche;
    }

    public void setPorcentajeVariacionLeche(Double porcentajeVariacionLeche) {
        this.porcentajeVariacionLeche = porcentajeVariacionLeche;
    }

    public Double getPorcentajeGrasa() {
        return porcentajeGrasa;
    }

    public void setPorcentajeGrasa(Double porcentajeGrasa) {
        this.porcentajeGrasa = porcentajeGrasa;
    }

    public Double getPorcentajeVariacionGrasa() {
        return porcentajeVariacionGrasa;
    }

    public void setPorcentajeVariacionGrasa(Double porcentajeVariacionGrasa) {
        this.porcentajeVariacionGrasa = porcentajeVariacionGrasa;
    }

    public Double getPorcentajeSolidosTotales() {
        return porcentajeSolidosTotales;
    }

    public void setPorcentajeSolidosTotales(Double porcentajeSolidosTotales) {
        this.porcentajeSolidosTotales = porcentajeSolidosTotales;
    }

    public Double getPorcentajeVariacionSolidosTotales() {
        return porcentajeVariacionSolidosTotales;
    }

    public void setPorcentajeVariacionSolidosTotales(Double porcentajeVariacionSolidosTotales) {
        this.porcentajeVariacionSolidosTotales = porcentajeVariacionSolidosTotales;
    }

    public Double getPagoLeche() {
        return pagoLeche;
    }

    public void setPagoLeche(Double pagoLeche) {
        this.pagoLeche = pagoLeche;
    }

    public Double getPagoGrasa() {
        return pagoGrasa;
    }

    public void setPagoGrasa(Double pagoGrasa) {
        this.pagoGrasa = pagoGrasa;
    }

    public Double getPagoSolidosTotales() {
        return pagoSolidosTotales;
    }

    public void setPagoSolidosTotales(Double pagoSolidosTotales) {
        this.pagoSolidosTotales = pagoSolidosTotales;
    }

    public Double getBonificacionFrecuencia() {
        return bonificacionFrecuencia;
    }

    public void setBonificacionFrecuencia(Double bonificacionFrecuencia) {
        this.bonificacionFrecuencia = bonificacionFrecuencia;
    }

    public Double getDsctoVariacionLeche() {
        return dsctoVariacionLeche;
    }

    public void setDsctoVariacionLeche(Double dsctoVariacionLeche) {
        this.dsctoVariacionLeche = dsctoVariacionLeche;
    }

    public Double getDsctoVariacionGrasa() {
        return dsctoVariacionGrasa;
    }

    public void setDsctoVariacionGrasa(Double dsctoVariacionGrasa) {
        this.dsctoVariacionGrasa = dsctoVariacionGrasa;
    }

    public Double getDsctoVariacionSolidosTotales() {
        return dsctoVariacionSolidosTotales;
    }

    public void setDsctoVariacionSolidosTotales(Double dsctoVariacionSolidosTotales) {
        this.dsctoVariacionSolidosTotales = dsctoVariacionSolidosTotales;
    }

    public Double getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(Double pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public Double getMontoRetencion() {
        return montoRetencion;
    }

    public void setMontoRetencion(Double montoRetencion) {
        this.montoRetencion = montoRetencion;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Double montoFinal) {
        this.montoFinal = montoFinal;
    }
}
