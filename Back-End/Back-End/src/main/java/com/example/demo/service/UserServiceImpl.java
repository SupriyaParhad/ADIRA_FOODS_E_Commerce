package com.example.demo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.NewUserDto;
import com.example.demo.dto.UserRegResponse;
//import com.example.demo.entities.Role;
import com.example.demo.entities.User;

//import com.example.demo.repository.INewCustomerDao;
import com.example.demo.repository.IUserDao;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	//UserRoles userRoles;
	
	//@Autowired
//	Role role;
	
	//@Autowired
	//INewCustomerDao newCust;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	IUserDao userdao;
	
//	@Autowired
	//NewUserDto newUserDto;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserRegResponse saveUserDetails(NewUserDto transientUser) {
		
		System.out.println("User Details :"+transientUser);
		User userEntity = mapper.map(transientUser, User.class);
		userEntity.setPassword(encoder.encode(transientUser.getPassword()));
		User persistentUser = userdao.save(userEntity);
		return new UserRegResponse("User registered successfully with ID " + persistentUser.getId());
		
		
		// TODO Auto-generated method stub
				//newCust.save(new Role(transientCust.id,
				//transientUser.setRoles(userRoles.ROLE_CUSTOMER);
	//	userEntity.setRoles(newCust.findByRoleNameIn(transientUser.getRoles()));//findByUserRolesIn(newUserDto.getRoles()));
		
		/*Set<Role> roles = transientUser.getRoles().stream()
				.map(roleNames -> roleRepo.findByUserRoles(UserRoles.valueOf(roleNames)).get())
				.collect(Collectors.toSet());
		
		user.setRoles(roles);
		User user2 = userRepo.save(user);
		UserResponseDTO dto = new UserResponseDTO();
		BeanUtils.copyProperties(user2, dto);
		return dto;*/
		
	}
}
