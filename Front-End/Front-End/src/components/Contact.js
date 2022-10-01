import React from 'react'

<style>


</style>
const Contact = () => {
    return (
        <>
            <div className="main">
                <div className='contact'>
                <h1 className="py-4 text-center">Contact</h1>
                </div><br></br><br></br><br></br>
                <div className="card-a">
                    <div className="card-a-1">
                        <div className='card-heading'>
                            <h2 className='py-4 text-center'>You can Reach Us At</h2>
                        </div>
                        <div className='card-content'>

                        <h3>
                           Address : Kharadi, Pune.
                        </h3>
                        <ul style={{color : "green"}}>   
                            <h4>Contact Number</h4>
                            
                            <li>
                                <h4>8999185314</h4>
                            </li>
                    
                        </ul>
                      
                        </div>
                    </div>
                </div>
                <div className="card-b">
                    <div className="card-b-1">
                        <div className='card-heading'>
                            <h2 className='py-4 text-center'>Email</h2>
                        </div>
                        <div className='card-content'>

                        <h3>
                        If you have faced any problem please write us to the given email id :
                        </h3>
                        <ul style={{color : "blue"}}>
                            <li>
                                <h4>AdiraFoods@gmail.com</h4>
                            </li>
                            
                    
                        </ul>
                           
                        </div>
    
                    </div> 
                </div>
                <div className="card-c">
                    <div className="card-c-1">
                        <div className='card-heading'>
                            <h2 className='py-4 text-center'>Social Media</h2>
                        </div>
                        <div className='card-content' style={{textAlign:" center"}}>

                        <h3 style={{color : "green"}}>
                        Scan this code to follow <strong>ADIRA FOODS</strong> on <br></br><strong>Instagram</strong>
                        </h3>
                        <ul style={{color : "green"}}>
                            <p></p>
                            <img  src={'/assets/Instagram.png'} width="150" height="200" alt="Insta: adira.live.healthylife"/>
                                {/* <h4>nikitagholave335@gmail.com</h4> */}
                            
                            <p>
                            <img  src={'/assets/facebook.png'} width="80" height="90"/>
                                <h2><a href= "https://www.facebook.com/Healthy.live.life">Facebook</a> </h2>
                            
                                </p>
                        </ul>
                           
                        </div>
    
                    </div> 
                </div>
                
            
                
            </div>
        </>
    )
}

export default Contact