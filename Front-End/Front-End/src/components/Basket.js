import React from 'react';
import { useHistory } from 'react-router';
import UserServiceMethods from '../service/UserServiceMethods';
//import useNavigate from 'react-router-dom';

export default function Basket(props) {
    const { cartItems, onAdd, onRemove } = props;
    const itemsPrice = cartItems.reduce((a, c) =>a + c.unit_price * c.qty , 0);
  
    const shippingPrice = itemsPrice > 1000 ? 0 : 50;
    const totalPrice = itemsPrice + shippingPrice; 
    const history=useHistory();
 //const navigate=useNavigate();
    const handleClick =(e)=> {
       e.preventDefault()
       console.log(cartItems); 
       cartItems.map((item) => {
        item.quantity=item.qty;
       });
       console.log("After mapping");
       console.log(cartItems);
       const email = localStorage.email;

    UserServiceMethods.placeOrder(cartItems)
    .then((res)=> {
       // useNavigate("/Payment");
     //   props.history.push('/Payment');
     alert("You will receive delivery details on your contact Details");
     alert("Redirecting you to Home Page");
     //alert("Kindl");
        history.push("/");

        console.log("Products added to Cart");

       // props.history.push('/Payment');
    }) .catch(error => {

        alert("There was some mistake processing your Cart");
        alert("Kindly try after sometime");
        console.log(error);
    //    props.history.push('/Payment');
    });
    }
    
    
    return (
       <aside className="block col-1">
        <h2>Cart Items</h2>
        <div>{cartItems.length === 0 && <div>Cart Is Empty</div>}
        {cartItems.map((item) => (
            <div key={item.id} className="row">
                
            <div className="col-2">{item.title}</div>
            
            <div className="col-2">
            <button onClick={() => onAdd(item)} className="add">+</button>{' '}
            <button onClick={() => onRemove(item)} className="remove">-</button>{' '}
            </div>
            <div className="col-2 text-right">
                {item.qty} x Rs.{item.unit_price}
            </div>
            </div>
        ))}
        {cartItems.length !==0 && (
            <>
            <hr></hr>
            <div className="row">
                <div className="col-2">Items Price</div>
                <div className="col-1 text-right">Rs.{itemsPrice}</div>
            </div>

            <div className="row">
                <div className="col-2">Shipping Price</div>
                <div className="col-1 text-right">Rs.{shippingPrice}</div>
            </div>

            <div className="row">
                <div className="col-2"><strong>Total Price</strong></div>
                <div className="col-1 text-right"><strong>Rs.{totalPrice}</strong></div>
            </div>

<div>
    <br></br>
    <h2>Payment Details</h2>
<input id="name" type="text" className="form-control text-center mt-3" placeholder="Enter Card Holder's Name" required/>
<br></br>
<input id="cardnumber" type="number" className="form-control text-center" placeholder="Enter Card Number" required/>
<br></br>
<input maxLength="3" type="password" className="form-control text-center" name="cvv" placeholder="Enter CVV Number" required />
<br></br>
</div>

<div className="text-align:center">
    <div>
        <button type="submit" className="btn btn-lg btn-primary text-uppercase mt-3" onClick={handleClick}>Proceed</button>
    </div>
</div>

            </>
        )}
        </div>


        </aside>
    );
}