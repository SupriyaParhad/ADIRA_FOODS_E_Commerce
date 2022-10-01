import React, { Component } from 'react';
import AdminServiceMethods from '../service/AdminServiceMethods';
import './AdminShowProducts.css'

class AdminShowProducts extends Component {
    constructor(props) {
        super(props)
        this.state = {
            products: [],
            message: null
        }

        this.showProduct = this.showProduct.bind(this);
    }

    getCategory = () => {
        AdminServiceMethods.fetchAllCategories()
        .then(response => {
            console.log(response.data);
            this.setState({category : response.data,message:"Category List Fetched"});
        })
        .catch(error => {
            console.log("Error ala na")
         
        });
    }

    showProduct = () => {
        console.log(this.props.title);
        console.log(this.props.description);
        console.log(this.props.unit_price);
        console.log(this.props.quantity);

        AdminServiceMethods.fetchAllProducts()
            .then(response => {
                console.log(response.data);
                this.setState({ products: response.data, message: "Product list rendered successfully" });
            })
            .catch(error => {
                console.log("Error ala na")
              
            });
    }

    componentDidMount() {
        this.showProduct();
        this.getCategory();
    }

render() {
        
        return (
            <>
            <div className="container my-4">
              <div className="product-list">
                <table className="table table-bordered">
                    <thead className="bg-dark text-light">
                        <tr>
                            <th className="visually-hidden">Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Unit Price</th>
                            <th>Quantity</th>
                           
                        </tr>
                    </thead>
                    <tbody className='cart-items'>
                        {
                            
                           
                            this.state.products.map(
                                product =>
                                    <tr className='class-row'>
                                      <td className="visually-hidden">{product.id}</td>
                                        <td>{product.title}</td>
                                        <td>{product.description}</td>
                                        <td>{product.unit_price}</td>
                                        <td>{product.quantity}</td>
                                       
                                    </tr>
                            )
                            
                        }
                    </tbody>
                </table>
                </div>
                </div>
                </>

        )

    }


}
export default AdminShowProducts

                           		                            