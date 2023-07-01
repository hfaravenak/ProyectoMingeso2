import axios from "axios";

const API_URL = "http://localhost:8080/laboratorio/subir-lab";

class LabFileUploadService{
    
    CargarArchivo(file){
        return axios.post(API_URL, file);
    }
}

export default new LabFileUploadService()