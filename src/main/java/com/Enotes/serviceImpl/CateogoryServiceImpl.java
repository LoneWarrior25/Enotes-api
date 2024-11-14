package com.Enotes.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.Enotes.entities.Cateogory;
import com.Enotes.repositories.CateogoryRepository;
import com.Enotes.service.CateogoryService;

@Service
public class CateogoryServiceImpl implements CateogoryService{

	@Autowired
	private CateogoryRepository cateogoryRepo;
	
	
	@Override
	public Boolean saveCateogory(Cateogory cateogory) {
		
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
	public List<Cateogory> getAllCateogories() {
	
		List<Cateogory> allCateogories = cateogoryRepo.findAll();
		
		return allCateogories;
	}

}
