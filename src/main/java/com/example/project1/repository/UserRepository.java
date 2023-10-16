package com.example.project1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entiities.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	User findByEmail(String email);


}
