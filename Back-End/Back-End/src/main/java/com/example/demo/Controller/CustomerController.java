package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cart;

//import com.example.demo.entities.CustomerOrder;
//import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import com.example.demo.entities.ShoppingCart;
import com.example.demo.entities.User;
import com.example.demo.repository.IAdminDao;
import com.example.demo.repository.ICartDao;
import com.example.demo.repository.ICartOrderDao;
import com.example.demo.repository.IUserDao;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.IUserService;

import lombok.extern.slf4j.Slf4j;

import com.example.demo.converter.ProductConverter;
import com.example.demo.dto.ProductDto;

@CrossOrigin
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

	List<Product> list=new ArrayList<Product>();
	List<ShoppingCart> cart=new ArrayList<ShoppingCart>();
	
	@Autowired
	IUserService userservice;
	
	@Autowired
	ICustomerService customerservice;
	
	@Autowired
	ICartDao cartdao;
	
	@Autowired
	ProductConverter productconverter;
	
	@Autowired 
	IAdminDao admindao;
	
	@Autowired 
	IUserDao userdao;
	
	public CustomerController()
    {
    	System.out.println("in ctor of "+getClass());
    }
 
	//View Menu
    @GetMapping("/findAll")     //DisplayAllProducts()
    public List<ProductDto> findAll()
    {
        List<ProductDto> productlist= customerservice.DisplayAllProducts();
        return productlist;
    	//return productconverter.ListentityToDtolist(productlist); 
    }
    
    @PostMapping("/payment")
    public String doPayment()
    {
    	String str="Your Payment is Successful";
    	return str;
    }
    
    
	@PostMapping("/placeOrder/{email}")
    public String placeOrder(@RequestBody ShoppingCart[] list,@PathVariable String email) {
    	LoginController log=new LoginController();
    	
    System.out.println("In place Order");
    System.out.println("Email : "+email);
    User user1=userdao.getUserByUserName(email);
    System.out.println("This user has placed a new order: "+user1);
  
    customerservice.saveCustomerOrderCart(list,user1.getId());
    return ("Order Placed Successfully");
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* @PostMapping("/add")
	 	public ResponseEntity<User> saveCustomer(@RequestBody @Valid  User user)
//	 	// To inform SC , to un marshall(de-serialization , json/xml --> Java obj) the
//	 	// method arg.
	 	{
	 		System.out.println("in save emp " + user);// id : null...
	 	
	 		
	 		return new ResponseEntity<>(userservice.saveUserDetails(user), HttpStatus.CREATED);
	 	}
//		
	  */
	
	
    
  //  @PostMapping("/placeOrder")
   // public ResponseEntity<?> placeOrder(@RequestBody Set<ShoppingCart> )
    
    
    
    
    
    
    
    
    
    
    
	 /*   @PostMapping("/addOrder")
	 	public ResponseEntity<CustomerOrder> saveOrder()
//	 	// To inform SC , to un marshall(de-serialization , json/xml --> Java obj) the
//	 	// method arg.
	 	{
	    	CustomerOrder custorder=new CustomerOrder();
	    	//custorder.setAmount(gettotal());
	    	//custorder.setOrderlist(list);
	    	
	    	System.out.println("in save emp " + custorder);// id : null...
	 	//	return  ResponseEntity.ok(customerservice.saveCustomerDetails(cust));
	 		
	 		return new ResponseEntity<>(customerservice.saveCustomerOrder(custorder), HttpStatus.CREATED);
	 	}
	*/
	    
	    //@PostMapping("/gettotal")
	  /*  public double gettotal()//@RequestBody @Valid List<Product> prod)
	    {
	    	double amt = customerservice.caluclateTotalAmount();
	    	return amt;	
	    }
	    */
	    //for transient cart ... adding a product in cartlist
	   /* @PostMapping("/getcartlist")
	    public List<Product> displayProdList(@RequestBody @Valid  ProductDto proddto)
	    {
	    	list=customerservice.addToList(proddto);
	    	return list; 
	 //   	double amt = customerservice.caluclateTotalAmount(prod);
	  //  	return amt;
	    }
	    
	    //private Logger logger=LoggerFactory.getLogger(
	    
	    /*public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId)
	    {
	    	Order order=customerservice.getOrderDetail(orderId);
	    	return 
	    }*/
	    
	/*   @PostMapping("/placeOrder")
	    public void placeOrder( list) {
	    	
		   customerservice.saveCustomerOrderCart(list);
	    	
	   }
	  //latest working  	
	/*    @PostMapping("/placeOrder/{email}")
	    	public ResponseEntity<?> placeOrder(@RequestBody Set<ShoppingCart> list,@PathVariable String email)
	    	{
	    	
	    	//	Cart cart=customerservice.newSaveCustomerCart(list,email);
	    		return new ResponseEntity<>(customerservice.newSaveCustomerCart(list,email), HttpStatus.CREATED);
	    	
	    	}
	    	    //saveCustomerCart()
	    	   /* customerservice.saveCartItems(list,email);
	    		List<ShoppingCart> shoplist= Arrays.asList(list);
	    		Cart cart=new Cart(shoplist,email);
	    		//cartdao.save(cart);
	    		return new ResponseEntity<>(customerservice.saveCartItems(cart), HttpStatus.CREATED);
	    		*/
	  //  	}
	   // }
	  /*  @PostMapping("/placeOrder")
	    public void placeOrder(@RequestBody ShoppingCart[] list) {
	    	
	    	//List<ShoppingCart> shoplist=new ArrayList();
	    	for(int i=0;i<list.length;i++)
	    	{
	    	   ShoppingCart shopcart=new ShoppingCart() ;
	    		List<ShoppingCart> shoplist = Arrays.asList(list);
	    		
	    	      //System.out.println(list);
	    	   shopcart.setId(list[i].getId());
	    	   shopcart.setQuantity(list[i].getQuantity());
	    	   shopcart.setUnit_price(list[i].getUnit_price());
	    	   shopcart.setTitle(list[i].getTitle());
	    	   shoplist.add(shopcart);
	    	   System.out.println(shoplist);
	    	//   customerservice.saveCustomerCart(shoplist);
	        }
	    }*/
    

}