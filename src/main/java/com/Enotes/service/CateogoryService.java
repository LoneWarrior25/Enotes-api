package com.Enotes.service;

import java.util.List;

import com.Enotes.dto.CateogoryDto;
import com.Enotes.dto.CateogoryResponse;


public interface CateogoryService {

	public Boolean saveCateogory(CateogoryDto cateogoryDto);
	
	public List<CateogoryDto> getAllCateogories();
	
	public List<CateogoryResponse> getActiveCateogories();
	
	public Boolean deleteCateogory(Integer id);
	
	public CateogoryDto getSingleCateogory(Integer id) throws Exception;
}
