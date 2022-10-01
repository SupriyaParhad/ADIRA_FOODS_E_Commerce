package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Category;

public interface ICategoryDao extends JpaRepository<Category, Integer> {

	Category getByName(String category);

}
