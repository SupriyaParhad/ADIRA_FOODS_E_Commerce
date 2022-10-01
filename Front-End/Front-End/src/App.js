import './App.css';
import React, { Component }  from 'react';
import UserSignUp from './components/UserSignUp'
import LandingPage from './components/LandingPage';
import Header from './components/Header';
import Footer from './components/Footer';
import About from './components/About';
import Contact from './components/Contact';
import UserLogin from './components/UserLogin';
import ShowProduct from './components/ShowProduct';
import ProductListForCustomer from './components/ProductListForCustomer';
import AdminShowProducts from './components/AdminShowProducts';
import Cards from './components/Cards';
import AdminDashboard from './components/AdminDashboard';
import AddNewDonor from './components/AddNewDonor';
import Header1 from './components/Header1';
import { Payment } from './components/Payment';


import {
  Switch,
  Route
} from 'react-router';
import Testimonial from './components/Cards';

function App() {
  return (
    <>
      <Header title="Welcome To ADIRA FOODS" />
      
     
      <Switch>
        <Route exact path="/" component={LandingPage}></Route>
        <Route exact path="/about" component={About}></Route>
        <Route exact path="/Contact" component={Contact}></Route>
        <Route exact path="/signup" component={UserSignUp}></Route>
       
        <Route exact path="/product" component={ProductListForCustomer}></Route>  
        <Route exact path="/userLogin" component={UserLogin}></Route>   
          <Route exact path="/Header1" component={Header1}></Route>
          <Route exact path="/AdminDashboard" component={AdminDashboard}>
           
           </Route>
           <Route eaxct path="/AddNewProduct" component={AddNewDonor}></Route>
           <Route exact path="/ShowAllProducts" component={AdminShowProducts}></Route>
           <Route exact path="/ShowProduct" component={ShowProduct}></Route>
           <Route exact path="/Testimonial" component={Cards}></Route>
           <Route exact path="/Payment" component={Payment}></Route>
      </Switch>
      <Footer />
    </>
  );
}

export default App;
