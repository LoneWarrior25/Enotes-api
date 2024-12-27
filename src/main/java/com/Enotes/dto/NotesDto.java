package com.Enotes.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotesDto {

//	private Integer id;
//	
//	private String title;
//	
//	private String description;
//	
//	private CateogoryDto cateogoryDto;
//	
//	private Integer createdBy;
//
//	private Date createdOn;
//
//	private Integer updatedBy;
//
//	private Date updatedOn;
	
	
	private Integer id;

	private String title;

	private String description;

	private CateogoryDto category;

	private Integer createdBy;

	private Date createdOn;

	private Integer updatedBy;

	private Date updatedOn;

}
