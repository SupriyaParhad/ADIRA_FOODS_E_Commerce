import React, { Component } from 'react';
import AdminServiceMethods from '../service/AdminServiceMethods';
import './AddNewProduct.css';
class AddNewDonor extends Component {
    constructor(props) {
        super(props)
        
        this.state = {
        product: {
            title: '',
            unit_price: '',
            quantity: '',
            description: '',
            mfg_date: '',
            exp_date:'',
            category:'',
            image:'',
            status:''
            
        },
        categorylist:[]
        }

        this.addProduct = this.addProduct.bind(this);
    }


    addProduct = e => {
        e.preventDefault();
        let prod =
        {
            ...this.state.product,
            status: "AVAILABLE",
            image:this.state.product.title
         
        };

        AdminServiceMethods.saveProduct(prod)
            .then(res => {
                console.log(res.data);
                this.setState({ message: 'New Product added successfully.' });
                alert(this.state.message);
                this.props.history.push('/adminDashboard');
            }).catch(error => {
                console.error("in err ", error.response.data);
               
                alert(error.response.data.message);
                this.props.history.push('/adminDashboard');
            });
    }

    getCategory = () => {
        AdminServiceMethods.fetchAllCategories()
        .then(response => {
         
            this.setState({categorylist : response.data,message:"Category List Fetched"});
        })
        .catch(error => {
            console.log("Error ala na")
         
        });
    }

    onChange = e =>
        this.setState({product:{...this.state.product, [e.target.name]: e.target.value }});

    handleBloodGroupChange = e => {
        this.setState({ bloodGroup: e.target.value })
    }

    myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
      }
      
      componentDidMount() {
        
        this.getCategory();
    }
     
    render() {
        return (
            <>
                <div className="container overflow-hidden" style={{ minHeight: "100vh" }}>
                    <div className="row mt-3">
                        <div className="col-sm-8">
                            <h2 className="text-muted offset-9">Add New Product</h2>
                        </div>
                        <div className="col-sm-4">
                            <button className="btn btn-secondary text-uppercase offset-8" onClick={() => { this.props.history.push('/adminDashboard') }}>Go Back</button>
                        </div>
                    </div>
                    <form>
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="username" className="col-2 col-form-label">Product Name</label>
                            <div className="col-5">
                                <input type="text" id="title" className="form-control" placeholder="Enter Product's name" name="title" value={this.state.product.title} onChange={this.onChange} />
                            </div>
                        </div>

                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="description" className="col-2 col-form-label">Description</label>
                            <div className="col-5">
                                <input type="text" id="description" className="form-control" placeholder="Sweet/ Spicy" name="description" value={this.state.product.description} onChange={this.onChange} />
                            </div>
                        </div>

                        <select name="category" onChange={this.onChange}>
                        {this.state.categorylist.map(
                            
                                category1 =>
                            {console.log(category1) 
                                   return <option value={category1}>{(category1)}</option> 
                            })}
                        </select>
                        
                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="unit_price" className="col-2 col-form-label">Price</label>
                            <div className="col-5">
                                <input type="number" id="unit_price" className="form-control" placeholder="Enter Unit Price" name="unit_price" value={this.state.product.unit_price} onChange={this.onChange} pattern="[0-9]" />
                            </div>
                        </div>

                        <div className="form-group row my-3 justify-content-center">
                            <label htmlFor="quantity" className="col-2 col-form-label">Quantity</label>
                            <div className="col-5">
                                <input type="number" id="quantity" className="form-control" placeholder="Enter Quantity" name="quantity" value={this.state.product.quantity} onChange={this.onChange} pattern="[0-9]" />
                            </div>
                        </div>

                        <div className="form-group row mt-3 justify-content-center">
                            <label htmlFor="mfg_date" className="col-2 col-form-label">Manufacture Date</label>
                            <div className="col-5">
                                <input type="date" id="mfg_date" className="form-control" placeholder=" Manufacturing Date" name="mfg_date" value={this.mfg_date} onChange={this.onChange} />
                            </div>
                        </div>

                        <div className="form-group row mt-3 justify-content-center">
                            <label htmlFor="exp_date" className="col-2 col-form-label">Expiry Date</label>
                            <div className="col-5">
                                <input type="date" id="exp_date" className="form-control" placeholder="Enter Expiry Date" name="exp_date" value={this.exp_date} onChange={this.onChange} />
                            </div>
                        </div>

                        <button className="btn btn-lg btn-primary text-uppercase mt-3 offset-2" onClick={this.addProduct}>Submit</button>
                    </form>
                </div>
            </>
        )
    }
}

export default AddNewDonor;
