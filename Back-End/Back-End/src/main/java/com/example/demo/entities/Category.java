package com.example.demo.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int category_id;
	   private String name;
	public Category(int category_id, String name) {
		super();
		this.category_id = category_id;
		this.name = name;
	}
	public Category() {
		super();
	}
}
