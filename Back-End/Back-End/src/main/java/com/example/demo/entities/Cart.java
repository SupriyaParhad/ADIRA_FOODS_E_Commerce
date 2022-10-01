/*package com.example.demo.entities;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.demo.dto.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cart_id;
    
	
    /*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	@MapsId*/
	//private User user;
    /*private String email;
	
   // @ElementCollection
    List<ShoppingCart> cartlist=new ArrayList<ShoppingCart>();

	public Cart(String email, List<ShoppingCart> cartlist) {
		super();
		this.email = email;
		this.cartlist = cartlist;
	}
  */ 
    /*ModelMapper modelMapper = new ModelMapper();
 // user here is a prepopulated User instance
    ProductDto ProductDTO = modelMapper.map(user, ProductDto.class);
 */
   // @Column
   // @OneToMany(mappedBy="cart")
  //  @ElementCollection//(targetClass=ProductDto.class)
  //  Map<Integer,Product> gfg = new HashMap<Integer,Product>();
   // List<Product> cartlist=new ArrayList<Product>();
//}

package com.example.demo.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.demo.dto.ProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cart_id;
    
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//	@JoinColumn(name = "user_id")
//	private List<Product> products;
	
//	private User user;
	
   /* @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	@MapsId
	private User user;
    */
	
  //  @ElementCollection
   // List<Product> cartlist=new ArrayList<Product>();
	@ElementCollection
	@OneToMany
	@JoinColumn(name="primid")
    Set<ShoppingCart> shoppingCart;//new ArrayList<ShoppingCart>();
    private String email;
	
    
	public Cart(Set<ShoppingCart> shoplist, String email) {
	//	super();
	this.shoppingCart = shoplist;
		this.email = email;
	}
   
    /*ModelMapper modelMapper = new ModelMapper();
 // user here is a prepopulated User instance
    ProductDto ProductDTO = modelMapper.map(user, ProductDto.class);
 */
   // @Column
   // @OneToMany(mappedBy="cart")
  //  @ElementCollection//(targetClass=ProductDto.class)
  //  Map<Integer,Product> gfg = new HashMap<Integer,Product>();
   // List<Product> cartlist=new ArrayList<Product>();
}

