import React, { Component } from "react";
import styled from "styled-components";
import { createGlobalStyle } from 'styled-components'


export default function Home(){
    
    return (
        <div>
            <GlobalStyle />
            <HomeStyle>
                <h1 className="text-center"> <b>MilkStgo</b></h1>
                <div class="box-area">
                    <div class="single-box">
                        <a href="/subir-archivo-acopio">
                            <div class="img-area">
                            </div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Cargar archivo acopio</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/lista-proveedores">
                            <div class="img-area">
                            </div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Ver proveedores</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/subir-archivo-lab">
                            <div class="img-area"></div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Cargar archivo laboratorio</strong></span>
                        </div>
                    </div>
                    <div class="single-box">
                        <a href="/ingresar-proveedor">
                            <div class="img-area"></div>
                        </a>
                        <div class="img-text">
                            <span class="header-text"><strong>Reporte pagos</strong></span>
                        </div>
                    </div>
                </div>
            </HomeStyle>
        </div>
    );
}



const GlobalStyle = createGlobalStyle`
    body { 
        background-color: #262626;
`
const HomeStyle = styled.nav`

.text-center {
    text-align: center;
    justify-content: center;
    padding-top: 8px;
    color: #fff;
}

.box-area{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
}

.single-box{
    position: relative;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 400px;
    height: auto;
    border-radius: 4px;
    background-color: #fff;
    text-align: center;
    margin: 20px;
    padding: 20px;
    transition: .3s
}

.img-area{
    display: flex;
    justify-content: center;
    align-items: center;
    width: 80px;
    height: 80px;
    border: 6px solid #ddd;
    border-radius: 50%;
    padding: 20px;
    -webkit-background-size: cover;
    background-size: cover;
    background-position: center center;
}

.single-box:nth-child(1) .img-area{
    background-image: url(https://img.freepik.com/vector-premium/chat-archivo-documento-texto-comentando-o-editando-documentos-linea-ilustracion-dibujos-animados-plana_101884-838.jpg)
}

.header-text{
    font-size: 23px;
    font-weight: 500;
    line-height: 48px;
}
.img-text p{
    font-size: 15px;
    font-weight: 400;
    line-height: 30px;
}
.single-box:hover{
    background: #e84393;
    color: #fff;}

.single-box:nth-child(2) .img-area{
        background-image: url(http://static1.squarespace.com/static/55c7a3e2e4b0fa365689d8aa/55e0aceae4b0643202e59629/55e322ade4b077beb0266329/1590769127854/?format=1500w)
}
.single-box:nth-child(3) .img-area{
        background-image: url(https://img.freepik.com/vector-premium/chat-archivo-documento-texto-comentando-o-editando-documentos-linea-ilustracion-dibujos-animados-plana_101884-838.jpg)
}
.single-box:nth-child(4) .img-area{
        background-image: url(https://img.freepik.com/vector-gratis/ingresos-netos-calculando-ilustracion-concepto-abstracto-calculo-sueldos-formula-ingresos-netos-salario-neto-contabilidad-corporativa-calculo-ganancias-estimacion-ganancias_335657-1238.jpg?w=2000)
}
.login-box{
    cursor: pointer;
}
`