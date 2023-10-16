package com.example.project1.service;

import java.util.List;


import com.example.project1.entiities.User;

public interface UserService {
	public List<User> getAllUsers();
	public String UpdateOrInsert(User user);
	public User getById(Integer pid);
	public String deleteById(Integer pid);
	public User getByEmail(String email);
	

}
