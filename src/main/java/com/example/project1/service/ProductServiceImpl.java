package com.example.project1.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.entiities.Product;
import com.example.project1.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> getAllProduct() {
		
		return productRepo.findAll();
	}

	@Override
	public String UpdateOrInsert(Product product) {
		
		productRepo.save(product);
		return "success";
	}

	@Override
	public Product getById(Integer pid) {
		
		Optional<Product> findById = productRepo.findById(pid);
		if(findById.isPresent()) {
			
			return findById.get();
			
		}
		return null;
	}

	@Override
	public String deleteById(Integer pid) {
		
	if (productRepo.existsById(pid)) {
		
		productRepo.deleteById(pid);
		return "Delete success!";
		
	}else {
		
		return "no record to delete";
	}
	
	
	}
	

}
