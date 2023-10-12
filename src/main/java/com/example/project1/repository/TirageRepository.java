package com.example.project1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.entiities.Tirage;

public interface TirageRepository extends JpaRepository<Tirage, Serializable>{

}
