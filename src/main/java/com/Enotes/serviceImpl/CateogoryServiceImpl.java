package com.Enotes.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.Enotes.Exceptions.ResourceNotFoundException;
import com.Enotes.dto.CateogoryDto;
import com.Enotes.dto.CateogoryResponse;
import com.Enotes.entities.Cateogory;
import com.Enotes.repositories.CateogoryRepository;
import com.Enotes.service.CateogoryService;
import com.Enotes.util.Validation;


@Service
public class CateogoryServiceImpl implements CateogoryService{

	@Autowired
	private CateogoryRepository cateogoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private Validation validation;
	
	
	
	
	@Override
	public Boolean saveCateogory(CateogoryDto cateogoryDto) {
		
//		Cateogory cateogory=new Cateogory();
//		
//		cateogory.setName(cateogoryDto.getName());
//		cateogory.setDescription(cateogoryDto.getDescription());
//		cateogory.setIsActive(cateogoryDto.getIsActive());
		
		validation.cateogoryValidation(cateogoryDto);

		Cateogory cateogory = this.modelMapper.map(cateogoryDto, Cateogory.class);
		
		if(ObjectUtils.isEmpty(cateogory)) {
			
			cateogory.setIsDeleted(false);
			cateogory.setCreatedBy(1);
			cateogory.setCreatedOn(new Date());
			
		}
		else {
			updateCateogory(cateogory);
		}
		
		
		Cateogory savedCateogory = cateogoryRepo.save(cateogory);
		
		if(ObjectUtils.isEmpty(savedCateogory)) {
			return false;
		}
		return true;
	}

	private void updateCateogory(Cateogory cateogory) {
		
		Optional<Cateogory> findById = cateogoryRepo.findById(cateogory.getId());
		
		if(findById.isPresent()) {
			
			Cateogory existedCateogory = findById.get();
			
			cateogory.setCreatedBy(existedCateogory.getCreatedBy());
			cateogory.setCreatedOn(existedCateogory.getCreatedOn());
			cateogory.setIsDeleted(existedCateogory.getIsDeleted());
			
			cateogory.setUpdatedBy(1);
			cateogory.setUpdatedOn(new Date());
		}
		
	}

	@Override
	public List<CateogoryDto> getAllCateogories() {
		
		List<Cateogory> cateogories = this.cateogoryRepo.findByIsDeletedFalse();
           
		List<CateogoryDto> cateogoryDto = cateogories.stream().map(cat-> this.modelMapper.map(cat, CateogoryDto.class)).toList();
		
		return cateogoryDto;
	}

	@Override
	public List<CateogoryResponse> getActiveCateogories() {
		
		List<Cateogory> cateogoryList = this.cateogoryRepo.findByIsActiveTrueAndIsDeletedFalse();
		
		List<CateogoryResponse> activeCateogories =  cateogoryList.stream().map(cat-> this.modelMapper.map(cat, CateogoryResponse.class)).toList();
		
		return activeCateogories;
	}

	@Override
	public Boolean deleteCateogory(Integer id) {
		
		Optional<Cateogory> findById = this.cateogoryRepo.findById(id);
		
		if(findById.isPresent()) {
			
			Cateogory cateogory = findById.get();
			cateogory.setIsDeleted(true);
			cateogoryRepo.save(cateogory);
			return true;
			
		}
		
		return false;
	}

	@Override
	public CateogoryDto getSingleCateogory(Integer id) throws Exception {

		Cateogory category = cateogoryRepo.findByIdAndIsDeletedFalse(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category not found with id=" + id));

		if (!ObjectUtils.isEmpty(category)) {
			category.getName().toUpperCase();
			return modelMapper.map(category, CateogoryDto.class);
		}
		return null;
	}
	}
	
	


