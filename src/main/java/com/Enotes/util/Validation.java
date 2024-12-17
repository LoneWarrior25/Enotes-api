package com.Enotes.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.Enotes.Exceptions.ValidationException;
import com.Enotes.dto.CateogoryDto;

@Component
public class Validation {

	public void cateogoryValidation(CateogoryDto cateogoryDto) {
	
	Map<String, Object> error=new LinkedHashMap<>();
	
	    if(ObjectUtils.isEmpty(cateogoryDto)) {
	    	
	    	throw new IllegalArgumentException("Object/JSOn cannot be null");
	    }
	    else {
	    	
	    	
	    	if(ObjectUtils.isEmpty(cateogoryDto.getName())) {
	    		error.put("name", "name cannot be blank");
	    	}
	    	else {
	    		
	    		if(cateogoryDto.getName().length()<10) {
	    			error.put("name", "name cannot be less than 10 characters");
	    		}
	    		
	    		if(cateogoryDto.getName().length()>100) {
	    			error.put("name", "name cannot be greater than 100 characters");
	    		}
	    		
	    	}
	    	
	    	// validation dscription
	    	
	    	if (ObjectUtils.isEmpty(cateogoryDto.getDescription())) {
				error.put("description", "description field is empty or null");
			}

			// validation isActive
			if (ObjectUtils.isEmpty(cateogoryDto.getIsActive())) {
				error.put("isActive", "isActive field is empty or null");
			} else {
				if (cateogoryDto.getIsActive() != Boolean.TRUE.booleanValue()
						&& cateogoryDto.getIsActive() != Boolean.FALSE.booleanValue()) {
					error.put("isActive", "invalid value isActive field ");
				}
			}
		}

		if (!error.isEmpty()) {
			throw new ValidationException(error);
		}
	    	
	    }
}

