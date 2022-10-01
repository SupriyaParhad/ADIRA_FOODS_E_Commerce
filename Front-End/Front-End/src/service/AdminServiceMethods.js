import axios from 'axios';

const ADMIN_API_BASE_URL = 'http://localhost:8080';

class AdminServiceMethods {
   
    logoutAdmin() {
        sessionStorage.removeItem("admin");
    }

    fetchAllProducts(){
        return axios.get(ADMIN_API_BASE_URL + '/admin/findAll');
    }

    fetchAllCategories(){
        return axios.get(ADMIN_API_BASE_URL + '/admin/findAllCategories');
     }

    saveProduct(prod){
        return axios.post(ADMIN_API_BASE_URL + '/admin/addproduct',prod);
    }


    // addNewDoctor(doctor){
    //     console.log(doctor);
    //     return axios.post(ADMIN_API_BASE_URL + '/doctorSignUp',doctor);
    // }

    // deleteDoctor(doctorId){
    //     return axios.delete(ADMIN_API_BASE_URL + '/removeDoctor/' + doctorId);
    // }

    // fetchAllPatients(){
    //     return axios.get(ADMIN_API_BASE_URL + '/getAllPatients');
    // }

    // deletePatient(patientId){
    //     return axios.delete(ADMIN_API_BASE_URL + '/removePatient/' + patientId);
    // }

    

    
}

export default new AdminServiceMethods();