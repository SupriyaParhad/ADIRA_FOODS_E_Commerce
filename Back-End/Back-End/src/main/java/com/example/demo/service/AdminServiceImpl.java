package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Category;

import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repository.IAdminDao;
import com.example.demo.repository.ICategoryDao;
import com.example.demo.repository.IUserDao;

//import custom_exception.ResourceNotFoundException;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private ModelMapper map1;
//	@Autowired
	//IUserDao userdao;
	
	@Autowired
	IAdminDao adminDao;
	
	@Autowired
	ICategoryDao categoryDao;
	
	@Override
	public Product getProductById(int prodId) {
		return adminDao.findById(prodId).orElseThrow();//(()->new ResourceNotFoundException("Invalid emp id !!!!!!" + prodId));
				//orElseThrow(()->new ResourceNotFoundException("Invalid emp id !!!!!!" + prodId));
		
	}
	
/*	@Override
	public Product getProductByName(String name) {
		return adminDao.getByName(name);//.orElseThrow();//(()->new ResourceNotFoundException("Invalid emp id !!!!!!" + prodId));
				//orElseThrow(()->new ResourceNotFoundException("Invalid emp id !!!!!!" + prodId));
		
	}
	
	/*@Override
	public User authenticateUser(String em, String pass) {
		// simply call dao's method for db based authentication
		return userdao.findByEmail(em)
				.orElseThrow(() -> new RuntimeException("Invalid email or password"));
	}*/

	@Override
	public String deleteProductsById(int prodId) {
		String mesg = "Deletion of product details failed!!!!!!!!!!!";

		if (adminDao.existsById(prodId)) {
			adminDao.deleteById(prodId);
			mesg = "Product details deleted successfully , for prod id :" + prodId;
		}

		return mesg;
	}

	@Override
	public void updateProductDetails(Product updatedDetachedProd, int id) {
		Product prod=adminDao.findById(id).orElseThrow();
		prod.setCategory(updatedDetachedProd.getCategory());
		
		//return adminDao.save(updatedDetachedProd);
	}

	@Override
	public Product saveProductDetails(ProductDto transientProd) {
		Product product = map1.map(transientProd, Product.class);
		Category category = categoryDao.getByName(transientProd.getCategory());
		product.setCategory(category);
		return adminDao.save(product);
	}

	@Override
	public Category AddNewCategory(Category transientCat) {
		return categoryDao.save(transientCat);
	}
	
	@Override
	public List<Product> showAllProducts() {
		GetAllCategory();
		return adminDao.findAll();
		
	}

	@Override
	public List<String> GetAllCategory() {
		List<Category> categorylist=categoryDao.findAll();
		List<String> name=new ArrayList<>();
	    for(Category cat:categorylist)
	    {
	        name.add(cat.getName());	
	    }
	    
	    System.out.println("Category Names : "+name);
	    return name;
	}
}


