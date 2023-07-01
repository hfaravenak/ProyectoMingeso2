import axios from "axios";

class AgregarProveedorService {
    
    AgregarProveedor(proveedor){
        return axios.post(`http://localhost:8080/proveedor/crear-proveedor`, proveedor);
    }
}

export default new AgregarProveedorService();