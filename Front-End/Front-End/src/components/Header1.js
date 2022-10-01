import React, { useState, useEffect } from 'react';
import Main from './Main';
import Basket from './Basket';
import ProductListForCustomer from './ProductListForCustomer';
import PatientServiceMethods from '../service/PatientServiceMethods';

  
function Header1(props) {
    const [products,setProducts] =  useState([]);
    const[cartItems,setCartItems] = useState([]);
    const getProductList =() => {
        PatientServiceMethods.fetchAllProducts()
       .then((response) => { 
            setProducts(response.data)
            console.log(response.data);
            
        });
    };

    

    useEffect(()=> {
        getProductList();
        
    }, [])

    

    const onAdd = (product) => {
        const exist=cartItems.find(x=> x.id === product.id);
        
        if(exist) {
           
            setCartItems(
                cartItems.map((x)=> 
                x.id === product.id ? { ...exist, qty:exist.qty + 1} : x
              
            ));
        }else {
          setCartItems([...cartItems,{ ...product,qty:1}]); 
        

        }
    };

    const onRemove = (product) => {
       const exist = cartItems.find((x) => x.id === product.id);
       if(exist.qty === 1) {
        setCartItems(cartItems.filter((x)=>x.id !== product.id));
            
       }
       else {
        setCartItems(
            cartItems.map((x)=> 
            x.id === product.id ? { ...exist, qty:exist.qty - 1} : x
          
        ));
         
       }
    }
    return (  
        
        <div className="App">
            <header className="row block center" > 
               
        <div className="shoppingCart">
            
        <a href="#/">
                <h1>Small Shopping Cart</h1>  
            </a>   
        </div>
        
         </header>          
        <div className="row"> 
         <Main products={products} onAdd={onAdd} ></Main>
         <Basket cartItems={cartItems} onAdd={onAdd} onRemove={onRemove}></Basket>
        </div>   
        </div>   
    );
}

export default Header1;

