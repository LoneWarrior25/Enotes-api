package com.Enotes.serviceImpl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.Enotes.dto.CateogoryDto;
import com.Enotes.dto.CateogoryResponse;
import com.Enotes.entities.Cateogory;
import com.Enotes.repositories.CateogoryRepository;
import com.Enotes.service.CateogoryService;

@Service
public class CateogoryServiceImpl implements CateogoryService{

	@Autowired
	private CateogoryRepository cateogoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public Boolean saveCateogory(CateogoryDto cateogoryDto) {
		
//		Cateogory cateogory=new Cateogory();
//		
//		cateogory.setName(cateogoryDto.getName());
//		cateogory.setDescription(cateogoryDto.getDescription());
//		cateogory.setIsActive(cateogoryDto.getIsActive());

		Cateogory cateogory = this.modelMapper.map(cateogoryDto, Cateogory.class);
		
		cateogory.setIsDeleted(false);
		cateogory.setCreatedBy(1);
		cateogory.setCreatedOn(new Date());
	
		Cateogory savedCateogory = cateogoryRepo.save(cateogory);
		
		
		if(ObjectUtils.isEmpty(savedCateogory)) {
			return false;
		}
		return true;
	}

	@Override
	public List<CateogoryDto> getAllCateogories() {
		
		List<Cateogory> cateogories = this.cateogoryRepo.findAll();
           
		List<CateogoryDto> cateogoryDto = cateogories.stream().map(cat-> this.modelMapper.map(cat, CateogoryDto.class)).toList();
		
		return cateogoryDto;
	}

	@Override
	public List<CateogoryResponse> getActiveCateogories() {
		
		List<Cateogory> cateogoryList = this.cateogoryRepo.findByIsActiveTrue();
		
		List<CateogoryResponse> activeCateogories =  cateogoryList.stream().map(cat-> this.modelMapper.map(cat, CateogoryResponse.class)).toList();
		
		return activeCateogories;
	}

}
