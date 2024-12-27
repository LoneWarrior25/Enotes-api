package com.Enotes.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.Enotes.Exceptions.ResourceNotFoundException;
import com.Enotes.dto.CateogoryDto;
import com.Enotes.dto.NotesDto;
import com.Enotes.entities.Cateogory;
import com.Enotes.entities.Notes;
import com.Enotes.repositories.CateogoryRepository;
import com.Enotes.repositories.NotesRepository;
import com.Enotes.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {
	
//	@Autowired
//	private CateogoryRepository catRepo;
//	
//	@Autowired
//	private NotesRepository notesRepo;
//	
//	@Autowired
//	private ModelMapper modelMapper;
//
//	@Override
//	public Boolean save(NotesDto notesDto) throws Exception {
//		
//		checkCateogoryExists(notesDto.getCateogoryDto());
//		
//		Notes notes = this.modelMapper.map(notesDto, Notes.class);
//		
//		Notes savedNotes = this.notesRepo.save(notes);
//		
//		if(!ObjectUtils.isEmpty(savedNotes)) {
//			return true;
//		}
//		
//		return false;
//	}
//	
//	
//	private void checkCateogoryExists(CateogoryDto cateogoryDto) throws ResourceNotFoundException {
//
//		Cateogory existCateogory = this.catRepo.findById(cateogoryDto.getId()).orElseThrow(()-> new ResourceNotFoundException("cateogory id invalid"));
//
//	}


//	public void checkCateogoryExists(CateogoryDto cateogoryDto) throws Exception {
//		
//		Cateogory existCateogory = this.catRepo.findById(cateogoryDto.getId()).orElseThrow(()-> new ResourceNotFoundException("cateogory id invalid"));
//		
//	}

//	@Override
//	public List<NotesDto> getAll() {
//		
//		
//		return notesRepo.findAll().stream().map(note -> modelMapper.map(note, NotesDto.class)).toList();
//
//	}
	
	@Autowired
	private NotesRepository notesRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private CateogoryRepository categoryRepo;

	@Override
	public Boolean saveNotes(NotesDto notesDto) throws Exception {

		// category validation
		checkCategoryExist(notesDto.getCategory());

		Notes notes = mapper.map(notesDto, Notes.class);
		Notes saveNotes = notesRepo.save(notes);
		if (!ObjectUtils.isEmpty(saveNotes)) {
			return true;
		}
		return false;
	}

	private void checkCategoryExist(CateogoryDto category) throws Exception {
		categoryRepo.findById(category.getId()).orElseThrow(() -> new ResourceNotFoundException("category id invalid"));
	}

	@Override
	public List<NotesDto> getAllNotes() {
		return notesRepo.findAll().stream().map(note -> mapper.map(note, NotesDto.class)).toList();
	}

	
	

}
