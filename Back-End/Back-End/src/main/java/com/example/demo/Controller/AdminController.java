package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converter.ProductConverter;
import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.IAdminDao;
import com.example.demo.service.IAdminService;


@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	
	@Autowired
	private IAdminService adminservice;
	
	@Autowired
	ProductConverter proddto;
	
	@Autowired 
	IAdminDao admindao;
	
	@Autowired
	ProductConverter productconverter;
	
	 public AdminController()
	    {
	    	System.out.println("in ctor of "+getClass());
	    }
	 
	 //get all products
	 @GetMapping("/findAll")
	    public List<Product> findAll()
	    {
		 System.out.println("In findAll");
	        List<Product> productlist= admindao.findAll();  
	        
	        return productlist;
	    	//return productconverter.ListentityToDtolist(productlist); 
	    }
	    
	 @GetMapping("/findAllCategories")
	    public List<String> findCategoryList()
	    {
		 return adminservice.GetAllCategory();
	       
	    	//return productconverter.ListentityToDtolist(productlist); 
	    }
	    
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<?> getProductsById(@PathVariable int id){
	    	return ResponseEntity.ok(adminservice.getProductById(id));
	    		
	    }
	 
	 @DeleteMapping("/{id}")
	    public ResponseEntity<?> DeleteProductsById(@PathVariable int id){
	    	return ResponseEntity.ok(adminservice.deleteProductsById(id));
	    	
	    }
	 // add a method to update existing resource
	 	@PatchMapping("/update/{id}")
	 	public String updateProductDetails(@RequestBody Product prod, @PathVariable int id) {
	 		System.out.println("in update product " + prod);// id not null
	 		return "Product Updated";//adminservice.updateProductDetails(prod,id);
	 	}
	 	
	 // add req handling method to create new emp
	 	@PostMapping("/addproduct")
	 	public ResponseEntity<Product> saveProductDetails(@RequestBody @Valid  ProductDto prod)
	 	// To inform SC , to un marshall(de-serialization , json/xml --> Java obj) the
	 	// method arg.
	 	{
	 		System.out.println("in save emp " + prod);// id : null...
//	 		return  ResponseEntity.ok(empService.saveEmpDetails(prod));
	 		
	 		return new ResponseEntity<>(adminservice.saveProductDetails(prod), HttpStatus.CREATED);
	 	}
	 	
	 	//add new category
	 	@PostMapping("/category")
	 	public ResponseEntity<Category> saveCategory(@RequestBody @Valid Category cat)
	 	{
	 		System.out.println("in save category " + cat);// id : null...
//	 		return  ResponseEntity.ok(empService.saveEmpDetails(prod));
	 	
	 		return new ResponseEntity<>(adminservice.AddNewCategory(cat), HttpStatus.CREATED);
	 		
	 	}
	
	 	@GetMapping("/enttodto/{id}")
	 	public ResponseEntity<ProductDto> convertToDto(@PathVariable int id)
	 	{
	 		Product prod=adminservice.getProductById(id);
	 		System.out.println("in  convertToDto category " + prod);// id : null...
//	 		return  ResponseEntity.ok(empService.saveEmpDetails(prod));
	 	
	 		return new ResponseEntity<>(proddto.entityToDto(prod), HttpStatus.CREATED);
	 	}
	 	
	 	@PostMapping("/dtotoent")
	 	public ResponseEntity<Product> convertToEnt(@RequestBody @Valid ProductDto proddtoenter)//(@PathVariable int id)
	 	{
	 		//Product prod=adminservice.getProductById(id);
	 		System.out.println("in  convertToEnt category "+ proddtoenter);// id : null...
//	 		return  ResponseEntity.ok(empService.saveEmpDetails(prod));
	 	
	 		return new ResponseEntity<>(proddto.dtotoentity(proddtoenter), HttpStatus.CREATED);
	 	}
	 	
	 	
		 /*	@GetMapping("/category")
		 	public String getCategory()//(@PathVariable int id)
		 	{
		 		Product prod=adminservice.getProductById(id);
		 		System.out.println("in  convertToDto category " + prod);// id : null...
//		 		return  ResponseEntity.ok(empService.saveEmpDetails(prod));
		 	
		 		return new ResponseEntity<>(proddto.entityToDto(prod), HttpStatus.CREATED);
		 	}
		 	*/
	 	
	 	
}
