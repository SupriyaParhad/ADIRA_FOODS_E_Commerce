package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ProductDto;
import com.example.demo.entities.Product;

@Component
public class ProductConverter {
   
	public ProductDto entityToDto(Product product)
	{
		
		/*ModelMapper modelMapper = new ModelMapper();
		// user here is a prepopulated User instance
		ProductDto dto = modelMapper.map(product, ProductDto.class);
		*/
		
		
		ProductDto dto=new ProductDto();
		dto.setId(product.getId());
		dto.setDescription(product.getDescription());
		//dto.setQuantity(product.getQuantity());
		dto.setImage(product.getImage());
		dto.setStatus(product.getStatus());
		dto.setTitle(product.getTitle());
		dto.setUnit_price(product.getUnit_price());
		return dto;
	}
	
	
	public Product dtotoentity(ProductDto productdto)
	{
		Product product =new Product(productdto.getId(),productdto.getTitle(),productdto.getQuantity(),productdto.getUnit_price(),productdto.getDescription());
		return product;
	}
	
	public List<ProductDto> ListentityToDtolist(List<Product> productlist)
	{
		return productlist.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}
	
	public List<Product> ListDtoToEntitylist(List<ProductDto> productdtolist)
	{
		return productdtolist.stream().map(x->dtotoentity(x)).collect(Collectors.toList());
	}
}
