package com.example.demo.dto;

//import com.example.demo.entities.UserRoles;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private String email;
	private String password;
//	private long mobileNumber;
  //  private UserRoles role;
    
}
