package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Cart;

public interface ICartDao extends JpaRepository<Cart, Integer> {

}
