import React from "react";
import styled from "styled-components";

function NavbarComponent6(){
    return(
        <>
        <NavStyle>
            <header class="header">
                <div class="logo">
                    <h1>MilkStgo</h1>
                </div>
                <nav>
                </nav>
                <a class="btn" href="/lista-proveedores"><button>Volver atrás</button></a>
            </header>
            </NavStyle>
        </>
    )
}

export default NavbarComponent6;


const NavStyle = styled.nav`
.header{
    background-color: #1b3039;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    height: 85px;
    padding: 5px 10%;
  }
.header .logo{
    margin-right: auto;
    color: white;
    font-family: 'Pacifico',serif;
  }
.header .btn button{
    margin-left: 20px;
    font-weight: 700;
    color: #1b3039;
    padding: 9px 25px;
    background: #eceff1;
    border: none;
    border-radius: 50px;
    cursor: pointer;
    transition: all 0.3s ease 0s;
  }
.header .btn button:hover{
    background-color: #e2f1f8;
    color: #ffbc0e;
    transform: scale(1.1);
  }
`