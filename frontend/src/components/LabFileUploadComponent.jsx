import React, { Component } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import NavbarComponent4 from "./NavBarComponent4";
import LabFileUploadService from "../services/LabFileUploadService";
import styled from "styled-components";
import swal from 'sweetalert';

class LabFileUploadComponent extends Component{
  constructor(props) {
    super(props);
    this.state = {
      file: null,
    };
    this.onFileChange = this.onFileChange.bind(this);
  }

  onFileChange(event) {
    this.setState({ file: event.target.files[0] });
  }
  
  onFileUpload = () => {
    swal({
      title: "¿Está seguro de que desea cargar este archivo?",
      text: "Tenga en cuenta que solo pueden ser cargados archivos '.csv' y su formato debe ser correcto.",
      icon: "warning",
      buttons: ["Cancelar", "Cargar"],
      dangerMode: true
    }).then(respuesta=>{
      if(respuesta){
        swal("Archivo cargado correctamente!", {icon: "success", timer: "3000"});
        const formData = new FormData();
        formData.append("file", this.state.file);
        LabFileUploadService.CargarArchivo(formData).then((res) => {
        });
      }
      else{
        swal({text: "Archivo no cargado.", icon: "error"});
      }
    });
  };

  render() {
    return (
      <div className="home">
        <NavbarComponent4 />
        <Styles>
          <div class="f">
            <div class="container">
              <h1><b>Cargar el archivo de datos de Laboratorio</b></h1>
              <Row className="mt-4">
                <Col col="12">
                  <Form.Group className="mb-3" controlId="formFileLg">
                    <Form.Control type="file" size="lg" onChange={this.onFileChange} />
                  </Form.Group>
                  <Button varian="primary" onClick={this.onFileUpload}>
                    Cargar el archivo a la Base de Datos</Button>
                </Col>
              </Row>
            </div>
          </div>
          <br>
          </br>
          <hr>
          </hr>
          <div class="form1">
            <h5><b>Recuerde que el archivo debe ser de tipo ".csv"!</b></h5>
          </div>
        </Styles>
      </div>
    );
  }
}

export default LabFileUploadComponent;


const Styles = styled.div`
.container{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin: 2%;
}
.f{
  margin-top: 40px;
  border: 3px solid rgb(162, 161, 161);
  padding: 40px;
  padding-top: 10px;
  border-radius: 40px;
  margin-left: 300px;
  margin-right: 300px;
}
@media(max-width: 1200px){
  .f{margin-left: 200px;
    margin-right: 200px;}
  
}
.form1{
  border: 1px solid rgb(82, 82, 173);
  padding: 30px;
  border-radius: 30px;
  margin-left: 300px;
  margin-right: 300px;
}
`