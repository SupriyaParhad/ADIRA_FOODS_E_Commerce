package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Prod_id")
	private int id;
	
	private String title;
     
	private int quantity;
	
    private int unit_price;
    
    private Date mfg_date;
    
    private Date exp_date;
    
    @ManyToOne//(cascade = CascadeType.ALL)
    Category category;
    
    private String description;
   
    private String image;
    
    private Status status;

	public Product(int id, String title, int quantity, int unit_price, Date mfg_date, Date exp_date,
			Category category_id, String description, String image, Status status) {
		super();
		this.id = id;
		this.title = title;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.mfg_date = mfg_date;
		this.exp_date = exp_date;
		this.category = category_id;
		this.description = description;
		//this.inventory = inventory;
		this.image = image;
		this.status = status;
	}

	public Product() {
		super();
	}

	public Product(int id,String title, int quantity, int unit_price,String description) {
		super();
		this.id=id;
		this.title = title;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.description = description;
	}

	public Product(String title, int quantity, int unit_price, Date mfg_date, Date exp_date, Category category,
			String description) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.mfg_date = mfg_date;
		this.exp_date = exp_date;
		this.category = category;
		this.description = description;
	}
    
    

}
