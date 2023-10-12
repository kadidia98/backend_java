package com.example.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.entiities.Tirage;
import com.example.project1.repository.TirageRepository;

@Service
public class TirageServiceImpl implements TirageService {
	
	@Autowired
		private TirageRepository tirageRepo;
	
	@Override
	    public List<Tirage> getAllTirage() {
	       
	        return tirageRepo.findAll();
	    }

	@Override
		public String UpdateOrInsert(Tirage tirage) {
		
		tirageRepo.save(tirage);
		return "success";
	}

	@Override
		public Tirage getById(Integer pid) {
		
			Optional<Tirage> findById = tirageRepo.findById(pid);
			
			if(findById.isPresent()) {
				
			return findById.get();
			
		}
			return null;
	}

	@Override
		public String deleteById(Integer pid) {
		
			if (tirageRepo.existsById(pid)) {
				
			tirageRepo.deleteById(pid);
			return "Delete success!";
			
			}else {
				
			return "no record to delete";
		}
	}

}
