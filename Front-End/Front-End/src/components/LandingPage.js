import React from 'react';
import './LandingPage.css';
import { NavLink } from 'react-router-dom';

const LandingPage = () => {
    return (
        <>
            <div className="container-fluid">
                <div id="carouselExampleCaptions" className="carousel slide" data-bs-ride="carousel">
                    <div className="carousel-inner">
                        <div className="carousel-item active">
                            <div className="imgStyle" >
                                <img src="assets/4.jpg" type="image/jpg" />
                                </div>
                            <div className="middleLayer bg-1"></div>
                            <div className="d-flex flex-column justify-content-center align-items-center w-100 h-100 position-fixed slideContent">
                                <h4 className="text-dark-grey font-weight-bolder text-uppercase">Good Food Quality</h4>
                                <div className="container w-50">
                                    <p className="display-6 text-grey text -center">Healthy food</p>
                                </div>
                                <div>
                                    <NavLink className="btn btn-link btn-lg btn-outline-light button1 text-uppercase text-decoration-none mx-3" to="/signup">Sign Up</NavLink>
                                    <NavLink className="btn btn-link btn-lg btn-outline-light button2 text-uppercase text-decoration-none mx-3" to="/userLogin">Login</NavLink>
                                    <NavLink className="btn btn-link btn-lg btn-outline-light button2 text-uppercase text-decoration-none mx-3" to="/ShowProduct">Product</NavLink>
                                </div>
                            </div>
                        </div>
                        <div className="carousel-item">
                        <div className="imgStyle" >
                                <img src="assets/3.jpeg" type="image/jpg" />
                                </div>
                            <div className="middleLayer bg-2"></div>
                            <div className="d-flex flex-column justify-content-center align-items-center w-100 h-100 position-fixed slideContent">
                                <h4 className="text-grey font-weight-bolder text-uppercase">Easy To Use</h4>
                                <div className="container w-50">
                                    <p className="display-6 text-grey text-center">Stay healthy.</p>
                                </div>
                                <div>
                                    <NavLink className="btn btn-link btn-lg btn-outline-light button1 text-light text-uppercase text-decoration-none mx-3" to="/signup">Sign Up</NavLink>
                                  
                                    <NavLink className="btn btn-link btn-lg btn-outline-light button2 text-uppercase text-decoration-none mx-3" to="/userLogin">Login</NavLink>
                                   
                                </div>
                            </div>
                        </div>
                        <div className="carousel-item">
                        <div className="imgStyle" >
                                <img src="assets/2.jpg" type="image/jpg" />
                                </div>
                            <div className="middleLayer bg-3"></div>
                            <div className="d-flex flex-column justify-content-center align-items-center w-100 h-100 position-fixed slideContent">
                                <h4 className="text-grey font-weight-bolder text-uppercase"></h4>
                                <div className="container w-50">
                                    <p className="display-6 text-grey text-center"></p>
                                </div>
                                
                                <div>
                                    <NavLink className="btn btn-link btn-lg btn-outline-light button1 text-light text-uppercase text-decoration-none mx-3" to="/signup">Sign Up</NavLink>
                                    <NavLink className="btn btn-link btn-lg btn-outline-light button1 text-light text-uppercase text-decoration-none mx-3" to="/userLogin">Login</NavLink>
                                   
                                </div>
                            </div>
                        </div>
                    </div>
                    <button className="carousel-control-prev prevButtonPosition" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Previous</span>
                    </button>
                    <button className="carousel-control-next nextButtonPosition" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </>
    )
}

export default LandingPage
