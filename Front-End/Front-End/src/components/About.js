import React from 'react'
import './About.css'

let flag=true
const About = () => {

    return (
        <>
           <div className='main'>
            
                <div className='aboutus'>
                    <h1 style={{fontSize: "40px"}}>About Us</h1>

                    <h5 className="navbar-tag">Unique & Beautiful</h5>
                </div> <br></br>
                
                <div className="card-a">

                    <div className="card-a-1">
                        <div className='card-heading'>
                            <h1>Services Provided</h1>
                        </div>
                        <div className='card-content'>

                            <h3>
                                <ul>
                                <li>Offers Delicious Food with Added Health Benefits.</li>
                                    <li> DoorStep Delivery of Products.</li><br></br>
                                    <li> Cater Overseas Bulk Orders.</li><br></br>
                                    
                                </ul>
                            </h3>
                        </div>

                    </div>
                   
                </div>
                <div className="card-b">

                    <div className="card-b-1">

                        <div className='card-heading'>
                            <h1>Future Scope</h1>
                        </div>
                        <div className='card-content'>
                            <h3>
                                <ul>
                                    <li> To expand overseas.</li> <br></br>
                                    <li> Introduce Ready To Cook Category.</li> <br></br>
                                    <li> Tie ups with firms.</li><br></br>
                                    <li> Introduce Ready to Use Spice Powders.</li>
                                </ul>
                            </h3>
                        </div>
                    </div>
                </div>
                <div className="card-c">

                    <div className="card-c-1">

                        <div className='card-heading'>
                            <h1>Our Speciality </h1>
                        </div>
                        <div className='card-content'>
                            <h3>
                                <ul>
                                    <li> Healthy Food</li><br></br>
                                    <li> Less Preparation Time</li><br></br>
                                    <li> Products loved by all age groups.</li><br></br>
                                    <li> StressFree Life</li><br></br>
                                    <li> Place order on fingertips from anywhere.</li>
                                </ul>
                            </h3>
                        </div>
                    </div>
                </div>

                <br></br>
                <br></br>
                <br></br>
                <br></br>
                <br></br>
                <br></br>




            </div>

        </>
    )
}
export default About;


