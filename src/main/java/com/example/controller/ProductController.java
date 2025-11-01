package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Product;
import com.example.service.ProductService;

import jakarta.validation.Valid;


@Controller
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("/")
	public String getProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product",product);
		return "product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@Valid Product product , BindingResult result , Model model) {
		if(result.hasErrors()) {
			return "product-form";
		}
		
//		System.err.println("Received Product ID: " + product.getId());
		
		model.addAttribute("msg",service.saveProduct(product));
		return "product-form";
	}
	
	@GetMapping("/products")
	public String AllProducts(Model model) {
		model.addAttribute("product",service.getAllProducts());
		return "products";
		
	}
	
	@GetMapping("/edit")
	public String editProduct(@RequestParam("id") int id, Model model) {
	    Product product = service.getProductById(id);
	    model.addAttribute("product", product);
	    return "product-form";
	}

	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id") int id) {
		service.deleteProductById(id); 
		return "redirect:/products";
	}
}
