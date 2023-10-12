package com.example.project1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entiities.Product;

public interface ProductRepository extends JpaRepository<Product, Serializable>{

}
