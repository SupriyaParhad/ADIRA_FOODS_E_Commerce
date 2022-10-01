package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.User;



public interface IUserDao extends JpaRepository<User, Integer> {
	//Optional<Admin> findByEmailAndPassword(String em, String pass);
	@Query("select u from User u where u.email =:email")
	public User getUserByUserName(@Param("email") String email);
}
