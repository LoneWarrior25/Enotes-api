package com.Enotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Enotes.Exceptions.ResourceNotFoundException;
import com.Enotes.dto.CateogoryDto;
import com.Enotes.dto.CateogoryResponse;
import com.Enotes.entities.Cateogory;
import com.Enotes.service.CateogoryService;

@RestController
@RequestMapping("/api/v1/cateogory")
public class CateogoryController {

	@Autowired
	private CateogoryService cateogoryService;

	@PostMapping("/save")
	public ResponseEntity<?> saveCateogory(@RequestBody CateogoryDto cateogoryDto) {

		Boolean savedCateogory = this.cateogoryService.saveCateogory(cateogoryDto);

		if (savedCateogory) {
			return new ResponseEntity<>("Cateogory saved successfully", HttpStatus.CREATED);
		}

		else {
			return new ResponseEntity<>("Cateogry not saved due to some error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCateogories() {

		List<CateogoryDto> cateogories = this.cateogoryService.getAllCateogories();
		if (ObjectUtils.isEmpty(cateogories)) {
			return ResponseEntity.noContent().build();
		}

		else {
			return new ResponseEntity<>(cateogories, HttpStatus.OK);
		}
	}

	@GetMapping("/get-active-cateogories")
	public ResponseEntity<?> getAactiveCateogories() {

		List<CateogoryResponse> cateogories = this.cateogoryService.getActiveCateogories();
		if (ObjectUtils.isEmpty(cateogories)) {
			return ResponseEntity.noContent().build();
		}

		else {
			return new ResponseEntity<>(cateogories, HttpStatus.OK);
		}
	}

	@GetMapping("/getSingleCateogory/{id}")
	public ResponseEntity<?> getSingleCateogory(@PathVariable Integer id) throws Exception{
		
		try {
			
			CateogoryDto singleCateogory = this.cateogoryService.getSingleCateogory(id);
			
			if(ObjectUtils.isEmpty(singleCateogory)) {
				
				return new ResponseEntity<>("Cannot found id :" + id,HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>("Requested Id is  :" + id,HttpStatus.OK);
			}
			}
			
			catch(ResourceNotFoundException e) {
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
			
		 catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

		
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCateogory(@PathVariable Integer id) {

		Boolean deleteCateogory = this.cateogoryService.deleteCateogory(id);

		if (deleteCateogory) {

			return new ResponseEntity<>("Cannot found id :" + id, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Deleted Id is  :" + id, HttpStatus.OK);
		}
	}
}
