package com.example.project1.service;

import java.util.List;

import com.example.project1.entiities.Tirage;



public interface TirageService {
	public List<Tirage> getAllTirage();
	public String UpdateOrInsert(Tirage tirage);
	public Tirage getById(Integer pid);
	public String deleteById(Integer pid);
}
