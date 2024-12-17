package com.Enotes.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CateogoryDto {

	private Integer id;

	@NotBlank(message="name cannot be blank")
	@Size(min=10,max=100)
	private String name;

	
	private String description;

	@NotNull
	private Boolean isActive;


	private Integer createdBy;

	private Date createdOn;

	private Integer updatedBy;

	private Date updatedOn;
}
