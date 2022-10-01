package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.converter.ProductConverter;
import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Cart;

//import com.example.demo.entities.CustomerOrder;
//import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.entities.User;
import com.example.demo.repository.IAdminDao;
import com.example.demo.repository.ICartDao;
import com.example.demo.repository.ICartOrderDao;
//import com.example.demo.repository.ICustomerOrderDao;
//import com.example.demo.repository.INewCustomerDao;
//import com.example.demo.repository.IOrderRepository;
import com.example.demo.repository.IUserDao;
import com.fasterxml.jackson.databind.json.JsonMapper;


@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	
	//List<Product> cartlist=new ArrayList<Product>();
//	List<ShoppingCart> orderlist=new ArrayList<ShoppingCart>();
	@Autowired
	ICartOrderDao cartorder;
	
	@Autowired 
	ICartDao cartdao;
	
//	@Autowired
  //  ICustomerOrderDao customerorderdao;
	
	@Autowired
    IUserDao userdao;
	
	
	@Autowired
	ProductConverter prodconv;
	
	@Autowired
	IAdminDao admindao;
	
	
	/*@Override
	public CustomerOrder saveCustomerOrder(CustomerOrder transientCustOrder) {
		transientCustOrder.setOrderlist(cartlist);
		//transientCustOrder.
		
		transientCustOrder.setAmount(caluclateTotalAmount());
		transientCustOrder.setOrder_date(LocalDate.now());
		transientCustOrder.setDelivery_date(LocalDate.now());
		return customerorderdao.save(transientCustOrder);
	}
*/	
	/*@Override
	public User saveUser(User transientUser) {
		
		return userdao.save(transientUser);
		
	}*/
	

	//Product Display to Customers
	@Override
	public List<ProductDto> DisplayAllProducts() {
		List<Product> prodlst=admindao.findAll();
		
		return prodconv.ListentityToDtolist(prodlst);
	}
	
	
	//save persistent order to table //have to redesign 
	@Override
	public void saveCustomerOrderCart(ShoppingCart[] transientCart,int id) {
		User user1=userdao.findById(id).orElseThrow();
		for(int i=0;i<transientCart.length;i++)
    	{
			ShoppingCart shopcart=new ShoppingCart() ;
    	   shopcart.setId(transientCart[i].getId());
    	   shopcart.setQuantity(transientCart[i].getQuantity());
    	   shopcart.setUnit_price(transientCart[i].getUnit_price());
    	   shopcart.setTitle(transientCart[i].getTitle());
    	   shopcart.setUser(user1);
    	   deductOrderQuantity(shopcart);
    	   cartorder.save(shopcart);
        }
		
	}
		//deductOrderQuantity();
		
//	}
	
	public Cart newSaveCustomerCart(Set<ShoppingCart> transientCart,String email) {
		//List<ShoppingCart> shoplist = JsonMapper.reader(transientCart, ShoppingCart.class);
		//List<ShoppingCart> shoplist = Arrays.asList(transientCart);
		cartorder.saveAll(transientCart);
		System.out.println("In saver to cart");
		System.out.println(transientCart);
		System.out.println("Email"+email);
		Cart cart=new Cart(transientCart,email);
		//cartdao.save(cart);
		return cartdao.save(cart);
		
		
	//	List<ShoppingCart> orderList = JsonMapper.readList(transientCart, ShoppingCart.class);
		//transientCart.setCartlist(cartlist);
		
		//return cartdao.save(transientCart);
				
	} 
	
	private void deductOrderQuantity(ShoppingCart order)
	{
		String prodname=order.getTitle();
		Product product=admindao.findByTitle(prodname);
		product.setQuantity(product.getQuantity()-order.getQuantity());
		
		/*for(Product prod:ordlist)
		{
		  int qty=prod.getQuantity();
	      Product product=admindao.findByTitle(prod.getTitle());	
	      product.setQuantity(product.getQuantity()-qty);
		}*/
	   
	}
	/*private void deductOrderQuantity(List<Product> ordlist)
	{
		for(Product prod:ordlist)
		{
		  int qty=prod.getQuantity();
	      Product product=admindao.findByTitle(prod.getTitle());	
	      product.setQuantity(product.getQuantity()-qty);
		}
	   
	}*/
	
	

	


	
	
}
