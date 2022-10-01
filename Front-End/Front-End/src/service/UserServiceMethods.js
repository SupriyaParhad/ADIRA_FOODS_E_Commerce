import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080';

class UserServiceMethods {
    
    addUser(user) {
        
       
        return axios.post(USER_API_BASE_URL + "/user/signUp",user);
    }

    placeOrder(cartItems)
    {
        let em=sessionStorage.getItem("email"); 
        return axios.post(USER_API_BASE_URL + `/customer/placeOrder/${em}`,cartItems);
    }
   /* getPatientById(patientId) {
        return axios.get(PATIENT_API_BASE_URL + '/getPatientDetails/' + patientId);
    }

    updatePatientDetails(id, patient) {
        console.log("yet aahe")
        return axios.put(PATIENT_API_BASE_URL + '/updatePatientDetails/' + id, patient);
    }*/

    logoutUser() {
        alert("Thank You For Visiting ADIRA FOODS");
        sessionStorage.removeItem("user");
    }
}

export default new UserServiceMethods();