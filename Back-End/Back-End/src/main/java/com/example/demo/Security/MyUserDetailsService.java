package com.example.demo.Security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.IUserDao;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserDao userdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// load user from db by username
		User user=userdao.getUserByUserName(username);
				
				if(user==null)
				{
					throw new UsernameNotFoundException("Not found");
				}
		
		CustomeUserDetailService customeUserDetails=new CustomeUserDetailService(user);
				return customeUserDetails;
				
			/*	
				.orElseThrow(()-> new sResourceNotFoundException("Email Not Found"));
		return new CustomeUserDetailService(user);*/
	}

}
