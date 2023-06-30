import { BrowserRouter, Route, Routes } from "react-router-dom";
import HomeComponent from './components/HomeComponent';
import AcopioFileUploadComponent from './components/AcopioFileUploadComponent';
import AcopioFileInformationComponent from './components/AcopioFileInformationComponent';
import LabFileUploadComponent from './components/LabFileUploadComponent';
import LabFileInformationComponent from './components/LabFileInformationComponent';
import ProveedoresComponent from './components/ProveedoresComponent';
import AgregarProveedor from './components/AgregarProveedorComponent';
import IngresarProveedor from './components/IngresarProveedorComponent';
import MostrarPlanillaComponent from './components/MostrarPlanillaComponent';

function App() {
  return (
    <div>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeComponent />} />
        <Route path= "/subir-archivo-acopio" element={<AcopioFileUploadComponent />} />
        <Route path= "/informacion-archivo-acopio" element={<AcopioFileInformationComponent />} />
        <Route path= "/subir-archivo-lab" element={<LabFileUploadComponent />} />
        <Route path= "/informacion-archivo-lab" element={<LabFileInformationComponent />} />
        <Route path= "/lista-proveedores" element={<ProveedoresComponent />} />
        <Route path= "/agregar-proveedor" element={<AgregarProveedor />} />
        <Route path= "/ingresar-proveedor" element={<IngresarProveedor />} />
        <Route path= "/planilla" element={<MostrarPlanillaComponent />} />

      </Routes>
    </BrowserRouter>
  </div>
  );
}

export default App;