package com.example.demo.service;

import com.example.demo.dto.NewUserDto;
import com.example.demo.dto.UserRegResponse;
import com.example.demo.entities.User;

public interface IUserService {

	UserRegResponse saveUserDetails(NewUserDto transientUser);

}
