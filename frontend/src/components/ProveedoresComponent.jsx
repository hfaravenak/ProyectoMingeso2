import React, { Component } from "react";
import NavBarComponent3 from "./NavBarComponent3";
import styled from "styled-components";

class ProveedoresComponent extends Component{
    constructor(props){
        super(props);
        this.state = {
            proveedores: [],
        };
    }

    componentDidMount(){
        fetch("http://localhost:8080/proveedor/listar-proveedores")
        .then((response) => response.json())
        .then((data) => this.setState({ proveedores: data }));
    }

    render(){
        return(
            <div className="home">
                <NavBarComponent3 />
                <Styles>
                <h1 className="text-center"> <b>Listado de proveedores</b></h1>
                    <div className="f">
                    <table border="1" class="content-table">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Categoria</th>
                                <th>Retencion</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.proveedores.map((proveedor) => (
                                <tr key={proveedor.codigo}>
                                    <td>{proveedor.codigo}</td>
                                    <td>{proveedor.nombre}</td>
                                    <td>{proveedor.categoria}</td>
                                    <td>{proveedor.retencion}</td>
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

export default ProveedoresComponent;

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