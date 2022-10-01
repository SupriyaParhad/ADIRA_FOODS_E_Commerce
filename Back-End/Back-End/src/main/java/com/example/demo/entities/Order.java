package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*@Entity
@ToString
@Getter
@Setter
@Table(name="myorder")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	*/
	/*@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private User user;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL, targetEntity=ShoppingCart.class)
	@JoinColumn(name="order_id", referencedColumnName="id")
	private List<ShoppingCart> cartItems;
	*/
	/*public Order(User customer, List<ShoppingCart> cartItems) {
		this.user = customer;
		this.cartItems = cartItems;
	}*/

	//public Order() {
		
	//}

//}
	

	

