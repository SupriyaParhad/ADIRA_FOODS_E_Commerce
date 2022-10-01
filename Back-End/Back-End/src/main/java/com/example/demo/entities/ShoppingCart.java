package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int primid;
    
    private int id;
    private String title;
    
    private int quantity;
    private float unit_price;
    
    @ManyToOne
    private User user;
    
	public ShoppingCart(int productId, String productName, int quantity, float amount) {
		super();
		this.id = productId;
		this.title = productName;
		this.quantity = quantity;
		this.unit_price = amount;
	}

	public ShoppingCart(int productId, int quantity) {
		super();
		this.id = productId;
		this.quantity = quantity;
	}
    
	public ShoppingCart() {
		
	}
    
	
    
    
}
