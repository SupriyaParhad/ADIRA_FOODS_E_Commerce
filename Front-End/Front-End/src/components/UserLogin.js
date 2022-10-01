import React, { Component } from 'react'
import UserLoginAPI from '../service/UserLoginAPI';
import { NavLink, Router} from 'react-router-dom';

class UserLogin extends Component {

    constructor(props) {
        super(props)

        this.state = {
            email: '',
            password: '',
            message: null
        }

        this.login = this.login.bind(this);
        this.onChange = this.onChange.bind(this);
    }


    login = e => {
        if(this.state.password == '') {
            alert("Password cannot be null")
            this.props.history.push("/userLogin")
            return false;
        }

        e.preventDefault();
        let user = {
            email: this.state.email,
            password: this.state.password,
        };
        if(this.state.email==="admin@adirafoods.com" && this.state.password==="ADMIN")
        {
            sessionStorage.setItem("ROLE_ADMIN",JSON.stringify(user));
            this.props.history.push('/AdminDashboard');
        }
        
        
        else {
                    UserLoginAPI.userLogin(user)
            .then(response => {
                console.log("User Login Details")
           
                this.setState({ message: 'Login successful.' });
                console.log(user.email);
                sessionStorage.setItem("ROLE_CUSTOMER", JSON.stringify(response.data));
               const token = response.data.token;
                localStorage.setItem("token",token);
                console.log("Received token :");
               
        
               
                sessionStorage.setItem("email",user.email);
           
                console.log(this.state.message);
                console.log("From session Storage");
                console.log(sessionStorage.getItem("ROLE_CUSTOMER"));
                this.props.history.push('/Header1');

            })
            .catch(error => {
                console.error("in err ");
               
                this.props.history.push('/userLogin');
            });
        }
        
            }
                
    validateEmail() {
        let email = document.getElementById("email").value;
        let emailRegex = /\S+@\S+\.\S+/;
        if(emailRegex.test(email) === true || email == '') {
            return true;
        }
        else {
            document.getElementById("emailVR").innerHTML = "Email format should be abc@xyz.com"
            return false;
        }
    }

    removeAlert() {
        document.getElementById("emailVR").innerHTML = "";
      
    }

    onChange = e => this.setState({ [e.target.name]: e.target.value });

    render() {
        return (
            <>
                <h2 className="text-center mt-5 mb-4">User Login</h2>
                <form className="container bg-dark pt-2" style={{ width: "30vw" }}>
                   
                    <div className="form-group">
                        <input id="email" type="email" className="form-control text-center mt-3" placeholder="Email" name="email" value={this.state.email} onChange={this.onChange} onBlur={this.validateEmail} onFocus={this.removeAlert} required /><span style={{color:"red"}} id="emailVR"></span>
                    </div>
                   
                    <div className="form-group my-3">
                        <input type="password" className="form-control text-center" name="password" placeholder="Password" value={this.state.password} onChange={this.onChange} required />
                    </div>
                    <div className="row my-3">
                        <div className="col-sm-7">
                            <button className="btn btn-success text-uppercase mb-3 offset-8" onClick={this.login} >LOGIN</button>
                        </div>
     
                    </div>
                </form>
                <span id="span"></span>
            </>
        )
    }
}

export default UserLogin