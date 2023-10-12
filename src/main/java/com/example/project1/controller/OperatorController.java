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

import com.example.project1.entiities.Operator;
import com.example.project1.service.OperatorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OperatorController {
	@Autowired
private OperatorService operatorService;
	
	@GetMapping("/operators")
	public ResponseEntity<List<Operator>> getOperators() {
		List<Operator> allOperator = operatorService.getAllOperator();
		return new ResponseEntity<List<Operator>>(allOperator, HttpStatus.OK);
	}
	
	
	@PostMapping("/operator")
	public ResponseEntity<String> createOperator(@RequestBody Operator operator){
	String status = operatorService.UpdateOrInsert(operator);
	
	return  new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/operator")
	public ResponseEntity<String> updateOperator(@RequestBody Operator operator){
		String status = operatorService.UpdateOrInsert(operator);
		
		return  new ResponseEntity<>(status,HttpStatus.OK);
		}
	
	@GetMapping("operator/{pid}")
	public ResponseEntity<Operator> getOperator(@PathVariable Integer pid) {
		Operator operator = operatorService.getById(pid);
		return new ResponseEntity<>(operator,HttpStatus.OK);
	}
	
	
	@DeleteMapping("operator/{pid}")
	public ResponseEntity<String> deleteOperator(@PathVariable Integer pid) {
		
		String status = operatorService.deleteById(pid);
		
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}

}
