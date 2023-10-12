package com.example.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.entiities.Operator;

import com.example.project1.repository.OperatorRepository;

@Service
	public class OperatorServiceImpl implements OperatorService {
		
	@Autowired
	private OperatorRepository operatorRepo;

	@Override
	public List<Operator> getAllOperator() {
		
		return operatorRepo.findAll();
	}

	@Override
	public String UpdateOrInsert(Operator operator) {
		
		operatorRepo.save(operator);
		return "success";
	}

	@Override
	public Operator getById(Integer pid) {
		
		Optional<Operator> findById = operatorRepo.findById(pid);
		
		if(findById.isPresent()) {
			
			return findById.get();
			
		}
		return null;
	}

	@Override
	public String deleteById(Integer pid) {
		
		if (operatorRepo.existsById(pid)) {
			
			operatorRepo.deleteById(pid);
			return "Delete success!";
			
		}else {
			
			return "no record to delete";
		}
	}

}
