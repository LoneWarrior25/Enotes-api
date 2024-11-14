package com.Enotes.service;

import java.util.List;

import com.Enotes.entities.Cateogory;

public interface CateogoryService {

	public Boolean saveCateogory(Cateogory cateogory);
	
	public List<Cateogory> getAllCateogories();
}
