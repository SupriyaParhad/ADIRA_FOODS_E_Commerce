package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ShoppingCart;

public interface ICartOrderDao extends JpaRepository<ShoppingCart, Integer> {

}
