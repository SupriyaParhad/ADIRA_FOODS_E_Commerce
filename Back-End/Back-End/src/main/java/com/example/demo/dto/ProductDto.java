package com.example.demo.dto;

import java.sql.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.entities.Cart;
import com.example.demo.entities.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private String title;
	private int quantity;
	private int unit_price;
	private String category;
	
	private Date mfg_date;
    
    private Date exp_date;
	
    private String Description;    
	private String image;
	private Status status;
	
	/*@ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;
	*/
	/*ModelMapper modelMapper = new ModelMapper();
	// user here is a prepopulated User instance
	UserDTO userDTO = modelMapper.map(user, UserDTO.class);
*/
}
