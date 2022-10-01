import React, { Component } from 'react';
import { NavLink } from "react-router-dom";
import PatientServiceMethods from '../service/PatientServiceMethods';
import Button from 'react-bootstrap/Button';
class ProductListForCustomer extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: [],
            message: null
        }

        this.getProductList = this.getProductList.bind(this);
    };

onChange = () =>
{
   var qty=document.getElementById('quantity')
   console.log(qty.ATTRIBUTE_NODE.valueOf);
}

    removeFromCart = () => {
        var removeCartItemButton=document.getElementsByClassName('danger')
        console.log(removeCartItemButton);
        for(var i=0;i<removeCartItemButton.length;i++){
            var button = removeCartItemButton[i]
            button.addEventListener('click',function(event){
                var buttonClicked=event.target
                buttonClicked.parentElement.parentElement.remove()
                console.log('clicked on Remove button')
                updateCartTotal()
            })
        }

        function updateCartTotal() {
          var cartItemsContainer=document.getElementsByClassName('cart-items')[0]
          var cartRows = cartItemsContainer.getElementsByClassName('cart-rows')
          for(var i=0;i<cartRows.length;i++)
          {
            var cartRow=cartRows[i]
            var price=this.cartRow.price
            var quantity=cartRow.getElementsByClassName('cart-quantity-input')[0]
            console.log(price,quantity)

          }
        }
            console.log(this.props.title);
            console.log(this.props.quantity);             
        }

    getProductList = () => {
        console.log(this.props.title);
        console.log(this.props.description);
        console.log(this.props.unit_price)

        PatientServiceMethods.fetchAllProducts()
            .then(response => {
                console.log(response.data);
                this.setState({ products: response.data, message: "Product list rendered successfully" });
            })
            .catch(error => {
                console.error("in err ", error.response.data);
                alert(error.response.data.message);
            });
    }

    componentDidMount() {
        this.getProductList();
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
                                <th colSpan="2" align='center'>Cart</th>
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
                                            <th><input className='cart-quantity-input' type="number" id="quantity" placeholder="Quantity to Order" name="quantity" value={this.state.quantity} onChange={this.onChange} required/></th>
                                           <th><Button className="danger" variant="danger" onClick={this.removeFromCart}>Remove</Button>{' '}</th>                                                 
                                        </tr>
                                )
                                
                            }
                        </tbody>
                    </table>
                    </div>
                    <div className="shopping-cart">
                        <table>
                        <table className="table table-bordered">
                        <thead className="bg-dark text-light">
                            <tr>
                                <th className="visually-hidden">Id</th>
                                <th>Name</th>
                                <th>Unit Price</th>
                                <th>Quantity</th>
                                <th colSpan="2" align='center'>Cart</th>
                            </tr>
                        </thead>
                        <tbody className='cart-items'>
                            {
                               <script>

                               </script> 
                                
                                
                            }
                        </tbody>
                    </table>
                        </table>
                    </div>
                </div>
            </>
        )

    }


}
export default ProductListForCustomer

