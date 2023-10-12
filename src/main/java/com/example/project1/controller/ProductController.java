package com.example.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.entiities.Product;
import com.example.project1.service.ProductService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
	@Autowired
private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> allProduct = productService.getAllProduct();
		return new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);
	}
	
	
	@PostMapping("/product")
	public ResponseEntity<String> createProduct(@RequestBody Product product){
	String status = productService.UpdateOrInsert(product);
	
	return  new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/product")
	public ResponseEntity<String> updateProduct(@RequestBody Product product){
		String status = productService.UpdateOrInsert(product);
		
		return  new ResponseEntity<>(status,HttpStatus.OK);
		}
	
	@GetMapping("product/{pid}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer pid) {
		Product product = productService.getById(pid);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	
	@DeleteMapping("product/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pid) {
		
		String status = productService.deleteById(pid);
		
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
}
