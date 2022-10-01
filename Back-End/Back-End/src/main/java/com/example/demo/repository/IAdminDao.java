package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


//import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;

public interface IAdminDao extends JpaRepository<Product,Integer> {

	//@Query(value="select p from Product p where p.title:=title")
	//Product getByName(String title);
      
	Product findByTitle(String title);
}
