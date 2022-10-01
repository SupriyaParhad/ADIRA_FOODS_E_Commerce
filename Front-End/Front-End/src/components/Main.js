import React, { Component, useEffect } from 'react';
import PatientServiceMethods from '../service/PatientServiceMethods';
import Product from './Product';
import { useState } from 'react';

function Main(props) {
    const [products,setProducts] = useState([])
    const {onAdd} = props
    useEffect(()=> {
        getProductList()
    }, [])


    const getProductList =() => {
        PatientServiceMethods.fetchAllProducts()
       .then((response) => { 
            setProducts(response.data)
            console.log(response.data);
        });
    };

    return (
       
        <main className="block col-2">
        
        <h2>Products</h2>   
        <div className="product-list"> 
                       <div className="row">
                           {products.map((product) =>
                                     
                                     (<Product key={product.id} product={product} onAdd={onAdd} ></Product>   
                                       
                                    ))
                            }
                      </div>
        </div>
        </main>
    );
}

export default Main
  