import axios from "axios";

const API_URL = "http://localhost:8080/acopio/subir-acopio";

class AcopioFileUploadService{
    
    CargarArchivo(file){
        return axios.post(API_URL, file);
    }
}

export default new AcopioFileUploadService()