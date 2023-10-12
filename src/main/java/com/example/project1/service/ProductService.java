package com.example.project1.service;

import java.util.List;

import com.example.project1.entiities.Product;

public interface ProductService {
	public List<Product> getAllProduct();
	public String UpdateOrInsert(Product product);
	public Product getById(Integer pid);
	public String deleteById(Integer pid);
}
