package com.example.demo.dto;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CustomerOrderDto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int order_id;
   // public int cust_id;
    private double amount;
    private Date order_date;
    private Date delivery_date;
    private double delivery_amount;
    private boolean delivery_status;    //use getBoolean("columnName") for changing bit to boolean
   // private double discount;
}
