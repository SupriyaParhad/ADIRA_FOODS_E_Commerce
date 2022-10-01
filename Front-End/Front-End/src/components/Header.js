import React from 'react';
import { NavLink } from 'react-router-dom';
import "./Header.css";
export default function Header(props) {

    let { title } = props;  
    let loggedIn = JSON.parse(sessionStorage.getItem("loginState"));
    return (
        <nav className="navbar navbar-expand-lg  navbar-dark blackbackground">
            <a className="navbar-brand" href="/">
                
            </a>
            <div className="container">
                <div className="navbar-header">
                    <img className="brand-logo" src="./assets/Logo_AdiraFoods.jpeg"></img>
                    <NavLink className="navbar-brand" to="">Adira Foods</NavLink>
                </div>
               
                <ul className="navbar-nav me-right mb-2 mb-lg-0">
                
                    <li className="nav-item"><NavLink className="nav-link active" to="/">Home</NavLink></li>
                    <li className="nav-item"><NavLink className="nav-link" to="/about">About Us</NavLink></li>
                    <li className="nav-item"><NavLink className="nav-link" to="/Testimonial">Reviews</NavLink></li>
                    <li className="nav-item"><NavLink className="nav-link" to="/contact">Contact Us</NavLink></li>
                </ul>
            </div>
        </nav>
    )
}

