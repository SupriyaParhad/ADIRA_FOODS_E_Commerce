package com.example.demo.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

//import com.example.demo.entities.UserRoles;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Size(min=4,message="Password size must be atleast of 4 character and max 10 characters")
	private String password;
	
	@NotEmpty
	@Size(min=4,message="First Name must be atleast 4 charachters")
    private String first_name;
	
	@NotEmpty
	@Size(min=4,message="Last Name must be atleast 4 charachters")
    private String last_name;
	
	@NotEmpty
	@Size(min=4,message="Address Name must be atleast 4 charachters")
    private String address;
	
	
  
	private long mobileNumber;
    
	protected String email;
    
}
