package com.example.demo.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.example.demo.dto.ProductDto;

import lombok.Getter;
import lombok.Setter;
/*

@Getter
@Setter
@Entity
public class CustomerOrder {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int order_id;
	    //private int cust_id;
	    private double amount;
	    private LocalDate order_date;
	    private LocalDate delivery_date;
	    private static final double delivery_amount=60;
	    //private boolean delivery_status;    //use getBoolean("columnName") for changing bit to boolean
	    //private double discount;
	    
	    private String payment_status;
	    
	 /*   @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name="user_id")
		@MapsId
		private User user;
	   */ 
	  /*  public CustomerOrder(double amount, LocalDate order_date, LocalDate delivery_date, String payment_status,
				Customer customer, List<Product> orderlist) {
			super();
			this.amount = amount;
			this.order_date = order_date;
			this.delivery_date = delivery_date;
			this.payment_status = payment_status;
			this.customer = customer;
			this.orderlist = orderlist;
		}
*/
	//	@ElementCollection//(targetClass=ProductDto.class)
	 //   List<Product> orderlist=new ArrayList<Product>();
	    
	 
	   
//}
