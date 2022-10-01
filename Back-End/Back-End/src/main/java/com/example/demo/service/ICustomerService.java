package com.example.demo.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Cart;

//import com.example.demo.entities.CustomerOrder;
//import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.entities.User;

public interface ICustomerService{

//	CustomerOrder saveCustomerOrder(CustomerOrder transientCustOrder);
	
	
	
	//double caluclateTotalAmount();
	

	
	//List<Product> addToList(ProductDto proddto);

	
     Cart newSaveCustomerCart(Set<ShoppingCart> list,String email);
	List<ProductDto> DisplayAllProducts();
	
	//Cart saveCustomerCart(Cart transientCart);

	

	//User saveUser(User transientUser);

//	void saveCustomerOrderCart(@Valid ShoppingCart transientCart,String email);
	void saveCustomerOrderCart(ShoppingCart[] transientCart,int id);

	

}
