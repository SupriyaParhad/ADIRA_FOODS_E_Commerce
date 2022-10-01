import axios from 'axios';

const CUSTOMER_API_BASE_URL = 'http://localhost:8080/customer';
axios.interceptors.request.use(
    config => {
       config.headers.authorization = `Bearer ${localStorage.getItem("token")}`;
       return config;
    },
    error => {
      return Promise.reject(error);
    }
);

class PatientServiceMethods {
    
    fetchAllProducts(){
        return axios.get(CUSTOMER_API_BASE_URL + '/findAll');
    }

    doPayment()
    {
        return axios.post(CUSTOMER_API_BASE_URL + '/payment');
    }
    
    // addPatient(patient) {
    //     return axios.post(PATIENT_API_BASE_URL + "/admin/add", patient);
    // }

    // getPatientById(patientId) {
    //     return axios.get(PATIENT_API_BASE_URL + '/getPatientDetails/' + patientId);
    // }

    // updatePatientDetails(id, patient) {
    //     console.log("yet aahe")
    //     return axios.put(PATIENT_API_BASE_URL + '/updatePatientDetails/' + id, patient);
    // }

    // logoutPatient() {
    //     sessionStorage.removeItem("patient");
    // }
}

export default new PatientServiceMethods();