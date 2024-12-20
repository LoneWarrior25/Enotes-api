package com.Enotes.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericResponse {

	private HttpStatus responseStatus;
	
	private String message;
	
	private String status;
	
	private Object data;
	
	
	public ResponseEntity<?> create(){
		
		Map<String, Object> map=new LinkedHashMap<>();
		
		map.put("message", message);
		map.put("status", status);
		
		if(ObjectUtils.isEmpty(data)) {
			
			map.put("data", data);
		}
		
		return new ResponseEntity<>(map,responseStatus);
	}
}
