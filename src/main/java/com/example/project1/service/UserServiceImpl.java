package com.example.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.entiities.User;
import com.example.project1.repository.UserRepository;




@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

@Override
    public List<User> getAllUsers() {
       
        return userRepo.findAll();
    }

@Override
	public String UpdateOrInsert(User user) {
	
	userRepo.save(user);
	return "success";
}

@Override
	public User getById(Integer pid) {
	
		Optional<User> findById = userRepo.findById(pid);
		
		if(findById.isPresent()) {
			
		return findById.get();
		
	}
		return null;
}

@Override
	public String deleteById(Integer pid) {
	
		if (userRepo.existsById(pid)) {
			
		userRepo.deleteById(pid);
		return "Delete success!";
		
		}else {
			
		return "no record to delete";
	}
}

@Override
public User getByEmail(String email) {
    return userRepo.findByEmail(email);
}

}
