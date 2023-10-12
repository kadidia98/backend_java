package com.example.project1.service;

import java.util.List;

import com.example.project1.entiities.Operator;



public interface OperatorService {
	public List<Operator> getAllOperator();
	public String UpdateOrInsert(Operator operator);
	public Operator getById(Integer pid);
	public String deleteById(Integer pid);
}
