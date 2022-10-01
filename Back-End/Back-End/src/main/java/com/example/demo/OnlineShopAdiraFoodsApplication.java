package com.example.demo;

import java.beans.JavaBean;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@JavaBean
@EnableConfigurationProperties
//@EntityScan(basePackages = {"com.example.demo.entities"})
public class OnlineShopAdiraFoodsApplication implements CommandLineRunner {
   
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineShopAdiraFoodsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("a"));
		 
	}
	
	@Bean
	public ModelMapper mapper()
	{
		 ModelMapper modelMapper = new ModelMapper();
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		 return modelMapper;
	}

	
	//@Override
	
	}




