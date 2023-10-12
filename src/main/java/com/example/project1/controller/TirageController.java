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

import com.example.project1.entiities.Tirage;

import com.example.project1.service.TirageService;


@CrossOrigin (origins = "http://localhost:3000")
@RestController
public class TirageController {

	@Autowired
private TirageService tirageService;
	
	@GetMapping("/tirages")
	public ResponseEntity<List<Tirage>> getTirages() {
		List<Tirage> allTirage = tirageService.getAllTirage();
		return new ResponseEntity<List<Tirage>>(allTirage, HttpStatus.OK);
	}
	
	
	@PostMapping("/tirage")
	public ResponseEntity<String> createTirage(@RequestBody Tirage tirage){
	String status = tirageService.UpdateOrInsert(tirage);
	
	return  new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/tirage")
	public ResponseEntity<String> updateTirage(@RequestBody Tirage tirage){
		String status = tirageService.UpdateOrInsert(tirage);
		
		return  new ResponseEntity<>(status,HttpStatus.OK);
		}
	
	@GetMapping("tirage/{pid}")
	public ResponseEntity<Tirage> getTirage(@PathVariable Integer pid) {
		Tirage tirage = tirageService.getById(pid);
		return new ResponseEntity<>(tirage,HttpStatus.OK);
	}
	
	
	@DeleteMapping("tirage/{pid}")
	public ResponseEntity<String> deleteTirage(@PathVariable Integer pid) {
		
		String status = tirageService.deleteById(pid);
		
		return new ResponseEntity<String>(status,HttpStatus.OK);
	}
	
	
	
	
}
