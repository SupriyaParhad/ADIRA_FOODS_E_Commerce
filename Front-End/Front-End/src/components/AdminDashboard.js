import React, { Component } from 'react';
import { NavLink } from "react-router-dom";
import AdminServiceMethods from '../service/AdminServiceMethods';


class AdminDashboard extends Component {
    constructor(props) {
        super(props)

        this.state = {
            email: '',
           // password: '',
            password: ''
        }

       this.loadAdmin = this.loadAdmin.bind(this);
    }

    componentDidMount() {
        this.loadAdmin();
    };

    loadAdmin = () => {
        let admin = JSON.parse(sessionStorage.getItem("admin"));
        this.setState({
            email: "admin@adirafoods.com",
           // password:"ADMIN"
            password: "ADIRA FOODS"
        });
    }

    logout() {
        AdminServiceMethods.logoutAdmin()
    }

    render() {

        let { email, password } = this.state;
        return (
            <>
                <div className="container">
                    <div className="row my-3">
                        <div className="col-sm-6"><h2 className="text-capitalize">Hello, {password}</h2></div>
                        <div className="col-sm-6">
                            <NavLink onClick={this.logout} className="btn btn-link btn-danger text-light offset-10 text-uppercase text-decoration-none " to="/">Logout</NavLink>
                        </div>
                    </div>

                     <div className="row">

                        <div className="col-sm-12">
                            <div className="card col-sm-12" >
                                <div className="card-body">
                                    <h5 className="card-title">View All Products</h5>
                                    <p className="card-text">View list of all products</p>
                                    <button onClick={() => { this.props.history.push('/ShowAllProducts') }} className="btn btn-warning">VIEW Products</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="row my-12">
                        <div className="col-sm-12">
                            <div className="card">
                                <div className="card-body">
                                    <h5 className="card-title">Add New Product</h5>
                                    <p className="card-text">Add New Product in existing Category.</p>
                                    <button onClick={() => { this.props.history.push('/AddNewProduct') }} className="btn btn-info">ADD New Product</button>
                                </div>
                            </div>
                        </div>
                        </div>
                   
                </div>
            </>
        )
    }
}

export default AdminDashboard


