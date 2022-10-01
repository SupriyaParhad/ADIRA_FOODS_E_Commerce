package com.example.demo.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.OnlineShopAdiraFoodsApplication;
import com.example.demo.Security.JwtAuthResponse;
import com.example.demo.Security.JwtTokenHelper;
import com.example.demo.dto.NewUserDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.User;
import com.example.demo.repository.IUserDao;
//import com.example.demo.entities.UserRoles;
import com.example.demo.service.CustomerServiceImpl;
import com.example.demo.service.IAdminService;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.IUserService;

//import com.example.demo;
//import com.app.pojos.User;
//import com.app.service.IUserService;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class LoginController {

	boolean flag=true;
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private IUserDao userdao;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	User user1;
	@PostMapping("/login")
	public ResponseEntity<?> createToken(
			@RequestBody @Valid UserDto user) throws Exception
	{
		System.out.println("In login");
		this.authenticate(user.getEmail(),user.getPassword());
	//	if(flag)
		//{
		
		  UserDetails userDetails = this.userDetailsService.loadUserByUsername(user.getEmail());
		  String token = this.jwtTokenHelper.generateToken(userDetails);
		  user1=userdao.getUserByUserName(userDetails.getUsername());
		  JwtAuthResponse response = new JwtAuthResponse();
		  
		  response.setToken(token);
		  
		  System.out.println("Token :"+token);
		
		  return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
		
	}

	
	
	private void authenticate(String email, String password) {
		
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(email,password);
		
		try
		{
		     this.authenticationManager.authenticate(authenticationToken);
		     
		}catch (BadCredentialsException e) {
			flag=false;
			System.out.println("Invalid Details"); 
			//throw new Exception("Invalid username or password!!");
		}
	} 

	@PostMapping("/signUp")
	public ResponseEntity<?>  saveCustomer(@RequestBody @Valid NewUserDto user)
	{
		//System.out.println("in reg user : user "+user+" roles "+user.getRoles());//{....."roles" : [ROLE_USER,...]}
		//invoke service layer method , for saving : user info + associated roles info
		
		System.out.println("In save Customer");
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUserDetails(user));		
	}

	}
	/*@PostMapping("/signUp")
	public ResponseEntity<User> addUser(
			@RequestBody @Valid User user) throws Exception
	{
		
		//this.authenticate(user.getEmail(),user.getPassword());
		
		//UserDetails userDetails = this.userDetailsService.loadUserByUsername(user.getEmail());
		
	/*	String token = this.jwtTokenHelper.generateToken(userDetails);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		System.out.println("Token :"+token);*/
		//return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
	//}
//}
/*
@PostMapping("/signUp")
	public ResponseEntity<User> saveCustomer(@RequestBody @Valid  User user)
//	// To inform SC , to un marshall(de-serialization , json/xml --> Java obj) the
//	// method arg.
	{
	    
		System.out.println("in save emp " + user);// id : null...
		user.setPassword(encoder.encode(user.getPassword()));
		List<String> roles = user.getRoles().stream().map((i)-> i.getUserRoles().toString())
				.collect(Collectors.toList());
		return new ResponseEntity<>(userService.saveUserDetails(user), HttpStatus.CREATED);
	}*/

	
/*@RestController
@RequestMapping("/user")
public class LoginController {
	@Autowired
	IAdminService adminservice;

	// dependency : service layer i/f
	@Autowired
	private ICustomerService customerService;

	public LoginController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to show login form
	@GetMapping("/login")
	public void showLoginForm() {
		System.out.println("in show login form");
		//return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
	}

	
	@PostMapping("/login")
	public ResponseEntity<?> processLoginForm(@RequestBody @Valid UserDto user)
	// reco : MATCH req param names to method arg names for easy binding
	// SC : String pwd=request.getParameter("pass");
	{
		String email=user.getEmail();
		String pwd=user.getPassword();
		System.out.println("in process login form " + email + " " + pwd);
		try {
			
		       if(user.getRole()==UserRoles.ADMIN)
		       {
		    	   
		    	   Admin admin=adminservice.authenticateUser(email, pwd);
		    		return new ResponseEntity<>(adminservice.showAllProducts(), HttpStatus.CREATED);
		    		
		       }
		       
			// invoke service layer method
		       else
		    	   {
		    	   Customer cust = customerService.authenticateUser(email, pwd);
		    	   return new ResponseEntity<>(customerService.DisplayAllProducts(), HttpStatus.CREATED);
		    	   }
			// => admin login success
			
		} catch (RuntimeException e) {
			System.out.println("err in " + getClass() + " exc " + e);
			return new ResponseEntity<>("Invalid Login",HttpStatus.PRECONDITION_FAILED);//check this out whether right or wrong
			 }
	
	}*/	


 
