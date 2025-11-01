package com.example.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repo.ProductRepo;
import com.example.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	ProductRepo repo;
	
	@Override
	public String saveProduct(Product product) {
		repo.save(product);
		return "Product Saved Successfully";
		
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> all = repo.findAll();
		return all;
	}

	@Override
	public Product getProductById(int i) {
		Product product = null;
		Optional<Product> id= repo.findById(i);
		if(id.isPresent()) {
			product = id.get();
		}
		return product;
	}

	@Override
	public void deleteProductById(int id) {
		
		repo.deleteById(id);
		
	}
	

}
