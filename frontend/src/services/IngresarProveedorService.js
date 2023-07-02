import axios from 'axios';

const API_URL = "http://localhost:8080/planilla";

class IngresarProveedorService {
    CrearPlanilla(proveedor) {
        const params = new URLSearchParams();
        params.append('proveedorId', proveedor);

        return axios.post(API_URL, null, { params })
            .then(response => response.data)
            .catch(error => {
                throw new Error(`Error al crear la planilla de pago: ${error.message}`);
            });
    }
}

const ingresarProveedorService = new IngresarProveedorService();
export default ingresarProveedorService;