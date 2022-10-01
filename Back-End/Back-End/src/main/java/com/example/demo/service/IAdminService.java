package com.example.demo.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;


public interface IAdminService {
	Product getProductById(int id);

	String deleteProductsById(int prodId);
	
	void updateProductDetails(Product updatedDetachedProd, @PathVariable int id);
	
	 Product saveProductDetails(ProductDto transientProd);
	 
	 Category AddNewCategory(Category cat);
	 List<String> GetAllCategory();

	List<Product> showAllProducts();

//	Product getProductByName(String name);

	//User authenticateUser(String em, String pass);
}
