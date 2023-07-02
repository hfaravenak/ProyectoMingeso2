import React, { useState } from "react";
import NavbarComponent7 from "./NavBarComponent7";
import styled from "styled-components";
import IngresarProveedorService from "../services/IngresarProveedorService";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import swal from 'sweetalert';

export default function IngresarProveedorComponent(props) {

    const initialState = {
        codigo: ""
    };

    const [input, setInput] = useState(initialState);

    const changeCodigoHandler = event => {
        setInput({ ...input, codigo: event.target.value });
        console.log(input.codigo);
    };

    const ingresarProveedor = async (event) => {
        event.preventDefault();

        try {
            const respuesta = await swal({
                title: "¿Está seguro de que desea generar la planilla de pago de este proveedor?",
                text: "",
                icon: "warning",
                buttons: ["Cancelar", "Enviar"],
                dangerMode: true
            });

            if (respuesta) {
                const res = await IngresarProveedorService.CrearPlanilla(input.codigo);

                swal("Planilla de pago efectuada correctamente!", { icon: "success", timer: "3000" });
                console.log("Respuesta exitosa:", res);

                window.location.href = '/planilla';
            } else {
                swal({ text: "Planilla no generada.", icon: "error" });
            }

        } catch (error) {
            swal("Error al generar la planilla de pago.", { icon: "error" });
            console.error("Error:", error);
        }
    };

    return (

        <Styles>
            <div className="home">
                <NavbarComponent7 />
                <div className="mainclass">
                    <div className="form1">
                        <h1 className="text-center"><b>Ingrese codigo del proveedor para obtener su planilla de pagos</b></h1>
                        <div className="formcontainer">
                            <hr></hr>
                            <div className="container">
                                <Form onSubmit={ingresarProveedor}>
                                    <Form.Group className="mb-3" controlId="codigo">
                                        <Form.Label>Codigo del proveedor</Form.Label>
                                        <Form.Control type="codigo" placeholder="Ingrese el código de proveedor" name="proveedorId" value={input.codigo} onChange={changeCodigoHandler} />
                                    </Form.Group>
                                    <Button className="boton" type="submit" >Obtener Planilla de Pagos</Button>
                                </Form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </Styles>
    )
}


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

.home{
    background-color: #006992;
    margin: 0;
    padding: 0;
}

.mainclass{
    margin-top: 20px;
    display: flex;
    justify-content: center;
    font-family: Roboto, Arial, sans-serif;
    font-size: 15px;
}

.form1{
    border: 9px solid #CED0CE;
    background-color: #DADDD8;
    width: 50%;
    padding: 36px;
}

input[type=rut], input[type=fecha] {
    width: 100%;
    padding: 16px 8px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

Button {
    background-color: #42bfbb;
    color: white;
    padding: 14px 0;
    margin: 10px 0;
    border: none;
    cursor: grabbing;
    width: 100%;
}

Button:hover {
    opacity: 0.8;
}

.formcontainer {
    text-align: left;
    margin: 24px 100px 9px;
}

.container {
    padding: 24px 0;
    text-align:left;
}

span.psw {
    float: right;
    padding-top: 0;
    padding-right: 15px;
}
`