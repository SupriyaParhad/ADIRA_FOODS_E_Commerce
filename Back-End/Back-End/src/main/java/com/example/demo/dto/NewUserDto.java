package com.example.demo.dto;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NewUserDto  {
	
	//@JsonProperty(access = Access.READ_ONLY) // user id will be serialized n sent to clnt BUT it won't be read from clnt
	// n de-serialized
	//@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//private int id;
	
	@NotBlank(message = "first name must be supplied")
	private String first_name;
	
	@NotBlank(message = "last name must be supplied")
	private String last_name;
	
	@NotBlank(message = "email must be supplied")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotBlank(message = "password must be supplied")
	private String password;
	
	private long mobileNumber;
	
	private String address;
	
}
