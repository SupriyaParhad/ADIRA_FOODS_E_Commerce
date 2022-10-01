import React, { Component, useEffect, useState } from 'react';
import UserServiceMethods from '../service/UserServiceMethods';


class UserSignUp extends Component {
    constructor(props) {
        super(props);
     
        this.state = {
            firstName: '',
            lastName: '',
            email: '',
            password: '',
            mobileNumber: '',
            address: ''  
        }

        this.addUser = this.addUser.bind(this);
    }

    validatePassword() {
        let password = document.getElementById("pwd").value;
        var regexPassword = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
        ///^(?=.\d)(?=.[!@#$%^&])(?=.[a-z]).{5,}$/;
 if (regexPassword.test(password) === true) {
            document.getElementById("passwordVr").innerHTML = "";
            return true;
        } else {
            document.getElementById("passwordVr").innerHTML = "password must be alphanumeric and should contains at least a special character with length 5"
        }

    }

    validateEmail() {
        let email = document.getElementById("email").value;

        var regexEmail = /\S+@\S+\.\S+/;
        if (regexEmail.test(email) === true) {
            document.getElementById("emailVr").innerHTML = "";
            return true;
        } else {
            document.getElementById("emailVr").innerHTML = "email format should be 'abc@gmail.com'"

        }

    }
    removeWarnings() {
        document.getElementById("passwordVr").innerHTML = "";
        document.getElementById("emailVr").innerHTML = "";
        document.getElementById("mobileNumberVr").innerHTML = "";

    }

    validateMobileNumber() {
        let number = document.getElementById('mobileNumber').value;
        if (/^\d{10}$/.test(number)) {
            document.getElementById("mobileNumberVr").innerHTML = "";

        } else {
            document.getElementById("mobileNumberVr").innerHTML = "Phone number must be 10 digits.";

            return false
        }
    }


    addUser = e => {
        e.preventDefault();
        console.log(this.state.beganPractice)
        let user =
        {
            first_name: this.state.firstName,
            last_name: this.state.lastName,
            email: this.state.email,
            password: this.state.password,
            mobileNumber: this.state.mobileNumber,
            address: this.state.address,
                      
        };

        UserServiceMethods.addUser(user)
            .then(res => {
                console.log(res.data);
                this.setState({ message: 'User added successfully.' });
                console.log(this.state.message);
                alert(this.state.message);
                this.props.history.push('/');
            })
            .catch((error) => {
                console.error("in err ", error.response.data);
                alert(error.response.data.message);
            });
    }

    onChange = e => this.setState({ [e.target.name]: e.target.value });

    render() {
        return (
            <>
                <div className="container overflow-hidden mb-5" style={{ minHeight: "100vh" }}>
                    <div className="row my-3">
                        <div className="col-sm-8">
                            <h2 className="text-muted text-danger offset-8">User Registration</h2>
                        </div>
                            {/* <div className="col-sm-4">
                                <button className="btn btn-secondary text-uppercase offset-8" onClick={() => { this.props.history.push('./') }}>Go Back</button>
                            </div> */}
                    </div>
                    <form className="mb-5">
                       
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="firstName" className="col-2 col-form-label">First Name</label>
                            <div className="col-5">
                                <input type="text" id="firstName" className="form-control" placeholder="Enter your first name" name="firstName" value={this.state.firstName} onChange={this.onChange} required />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="lastName" className="col-2 col-form-label">Last Name</label>
                            <div className="col-5">
                                <input type="text" id="lastName" className="form-control" placeholder="Enter your last name" name="lastName" value={this.state.lastName} onChange={this.onChange} required />
                            </div>
                        </div>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="email" className="col-2 col-form-label">Email</label>
                            <div className="col-5">
                                <input type="email" id="email" className="form-control" placeholder="e.g. abc@xyz.com" name="email" value={this.state.email} onChange={this.onChange} required onFocus={this.removeWarnings} onBlur={this.validateEmail} /><span style={{ color: 'red' }} id='emailVr'></span>

                            </div>
                        </div>

                       
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="pwd" className="col-2 col-form-label">Password</label>
                            <div className="col-5">
                                <input type="password" id="pwd" className="form-control" placeholder="Enter Password" name="password" value={this.state.password} onChange={this.onChange} onBlur={this.validatePassword} onFocus={this.removeWarnings} required /><span style={{ color: 'red' }} id='passwordVr'></span>

                            </div>
                        </div>
                       
                        
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="mobileNumber" className="col-2 col-form-label">Mobile</label>
                            <div className="col-5">
                                <input type="text" id="mobileNumber" className="form-control" placeholder="Enter your mobile number" name="mobileNumber" value={this.state.mobileNumber} onChange={this.onChange} pattern="[0-9]{10}" onBlur={this.validateMobileNumber} onFocus={this.removeWarnings} required /><span id='mobileNumberVr' style={{ color: 'red' }}></span>

                            </div>
                        </div>

                        <div className="form-group row mt-3 justify-content-center">
                            <label htmlFor="area" className="col-2 col-form-label">Addres</label>
                            <div className="col-5">
                                <input type="text" id="address" className="form-control" placeholder="Enter your Address" name="address" value={this.state.address} onChange={this.onChange} required />
                            </div>
                        </div>

                        <div className="form-group row justify-content-center">
                            <div className="offset-9">
                                <button type="submit" className="btn btn-lg btn-primary text-uppercase mt-3" onClick={this.addUser}>Sign Up</button>
                            </div>
                        </div>
                        
                    </form>
                </div>
            </>
        )
    }
}

export default UserSignUp