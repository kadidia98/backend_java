package com.example.project1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entiities.Operator;

public interface OperatorRepository extends JpaRepository<Operator, Serializable>{

}
