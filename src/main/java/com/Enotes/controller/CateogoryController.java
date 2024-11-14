package com.Enotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Enotes.entities.Cateogory;
import com.Enotes.service.CateogoryService;

@RestController
@RequestMapping("/api/v1/cateogory")
public class CateogoryController {
	
	@Autowired
	private CateogoryService cateogoryService;

	@PostMapping("/save")
	public ResponseEntity<?> saveCateogory(@RequestBody Cateogory cateogory){
		
		Boolean savedCateogory = this.cateogoryService.saveCateogory(cateogory);
		
		if(savedCateogory) {
			return new ResponseEntity<>("Cateogory saved successfully",HttpStatus.CREATED);
		}
		
		else {
			return new ResponseEntity<>("Cateogry not saved due to some error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCateogories(){
		
		List<Cateogory> cateogories = this.cateogoryService.getAllCateogories();
		if(ObjectUtils.isEmpty(cateogories)) {
			return ResponseEntity.noContent().build();
		}
		
		else {
			return new ResponseEntity<>(cateogories,HttpStatus.OK);
		}
	}
}
