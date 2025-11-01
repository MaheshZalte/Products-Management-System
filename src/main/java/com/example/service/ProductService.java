package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repo.ProductRepo;

@Service
public interface ProductService{
	
	String saveProduct(Product product);
	
	List<Product> getAllProducts();
	
	Product getProductById(int id);
	
	void deleteProductById(int id);
}
