import React ,{ Component }from 'react';
import PatientServiceMethods from '../service/PatientServiceMethods';

import { useState,useEffect } from 'react';


   

function ShowProduct() {
    const [products,setProducts] =  useState([]);
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
    return (
        <>
        {/* <div style={{backgroundImage:'url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIacUyGyckrZ_W_fTm3doXwPRBJSmzYlW_OA&usqp=CAU")', backgroundRepeat:"no-repeat",backgroundSize:"cover" }} > */}
        <div style={{backgroundImage:'url("./assets/foodImg.jpg")', backgroundRepeat:"no-repeat",backgroundSize:"cover"}}>

        {/* <main className="block"> */}
        <main>
        <h2>Products</h2>   
        <div className="product-list"> 
                       <div className="row">
                           {products.map((product) =>
                                     
                                     <div class="col-sm-3">
                                        <div style={{textAlign:"center",margin:"auto",marginBottom: "50px"}}>
    
                                        
                                     <img className="small" src={'/assets/'+product.image+'.jpg'} alt={product.title}/>
                                     <h3 style={{color:"white"}}><strong>{product.title}</strong></h3>
                                      <h6 style={{color:"white"}}><strong>{product.description}</strong></h6>
                                     <div><h6 style={{color:"white"}}><strong>Rs.{product.unit_price}</strong></h6></div>
                                   </div>
                                </div> 
                                       
                                    )}
                            
                      </div>
        </div>
        </main>
        </div>
        </>
    );
}

export default ShowProduct