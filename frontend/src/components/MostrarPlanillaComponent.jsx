import React, { Component } from "react";
import NavBarComponent8 from "./NavBarComponent8";
import styled from "styled-components";

class MostrarPlanillaComponent extends Component{
    constructor(props){
        super(props);
        this.state = {
            planillas: [],
        };
    }

    componentDidMount(){
        fetch("http://localhost:8080/planilla/listar-planillas")
        .then((response) => response.json())
        .then((data) => this.setState({ planillas: data }));
    }

    render(){
        return(
            <div className="home">
                <NavBarComponent8 />
                <Styles>
                <h1 className="text-center"> <b>Planilla de pagos</b></h1>
                    <div className="f">
                    <table border="1" class="content-table">
                        <thead>
                            <tr>
                                <th>Quincena</th>
                                <th>Código Proveedor</th>
                                <th>Nombre Proveedor</th>
                                <th>TOTAL KLS leche</th>
                                <th>Nro. días que envió leche</th>
                                <th>Promedio diario KLS leche</th>
                                <th>%Variación Leche</th>
                                <th>%Grasa</th>
                                <th>%Variación Grasa</th>
                                <th>%Solidos Totales</th>
                                <th>%Variación ST</th>
                                <th>Pago por leche</th>
                                <th>Pago por grasa</th>
                                <th>Pago por solidos totales</th>
                                <th>Bonificacion por frecuencia</th>
                                <th>Dcto. Variación Leche</th>
                                <th>Dcto. Variación Grasa</th>
                                <th>Dcto. Variación ST</th>
                                <th>Pago TOTAL</th>
                                <th>Monto Retención</th>
                                <th>Monto FINAL</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.planillas.map((planilla) => (
                                <tr key={planilla.codigo}>
                                    <td>{planilla.quincena}</td>
                                    <td>{planilla.codigoProveedor}</td>
                                    <td>{planilla.nombreProveedor}</td>
                                    <td>{planilla.totalKlsLeche}</td>
                                    <td>{planilla.nroDiasEnvioLeche}</td>
                                    <td>{planilla.promedioDiarioKlsLeche}</td>
                                    <td>{planilla.porcentajeVariacionLeche}</td>
                                    <td>{planilla.porcentajeGrasa}</td>
                                    <td>{planilla.porcentajeVariacionGrasa}</td>
                                    <td>{planilla.porcentajeSolidosTotales}</td>
                                    <td>{planilla.porcentajeVariacionSolidosTotales}</td>
                                    <td>{planilla.pagoLeche}</td>
                                    <td>{planilla.pagoGrasa}</td>
                                    <td>{planilla.pagoSolidosTotales}</td>
                                    <td>{planilla.bonificacionFrecuencia}</td>
                                    <td>{planilla.dsctoVariacionLeche}</td>
                                    <td>{planilla.dsctoVariacionGrasa}</td>
                                    <td>{planilla.dsctoVariacionSolidosTotales}</td>
                                    <td>{planilla.pagoTotal}</td>
                                    <td>{planilla.montoRetencion}</td>
                                    <td>{planilla.montoFinal}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                    </div>
                </Styles>
            </div>
        )
    }
}

export default MostrarPlanillaComponent;

const Styles = styled.div`


.text-center {
    text-align: center;
    justify-content: center;
    padding-top: 8px;
    font-family: "Arial Black", Gadget, sans-serif;
    font-size: 30px;
    letter-spacing: 0px;
    word-spacing: 2px;
    color: #000000;
    font-weight: 700;
    text-decoration: none solid rgb(68, 68, 68);
    font-style: normal;
    font-variant: normal;
    text-transform: uppercase;
}

.f{
    justify-content: center;
    align-items: center;
    display: flex;
}
*{
    font-family: sans-serif;
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}
.content-table{
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    min-width: 400px;
    border-radius: 5px 5px 0 0;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.content-table thead tr{
    background-color: #009879;
    color: #ffffff;
    text-align: left;
    font-weight: bold;
}
.content-table th,
.content-table td{
    padding: 12px 15px;
}
.content-table tbody tr{
    border-bottom: 1px solid #dddddd;
}
.content-table tbody tr:nth-of-type(even){
    background-color: #f3f3f3;
}
.content-table tbody tr:last-of-type{
    border-bottom: 2px solid #009879;
}
.content-table tbody tr.active-row{
    font-weight: bold;
    color: #009879;
}
`