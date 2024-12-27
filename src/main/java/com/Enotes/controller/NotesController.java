package com.Enotes.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Enotes.dto.NotesDto;
import com.Enotes.service.NotesService;
import com.Enotes.util.CommonUtils;

@RestController
@RequestMapping("api/v1/notes")
public class NotesController {
	
//	@Autowired
//	private NotesService notesService;
//
//	@PostMapping("/post")
//	public ResponseEntity<?> savenotes(@RequestBody NotesDto notesDto) throws Exception{
//		
//		Boolean savedNotes = this.notesService.save(notesDto);
//		
//		if(savedNotes) {
//			return CommonUtils.createBuildResponseMessage("notes saved", HttpStatus.CREATED );
//		}
//		
//		return CommonUtils.createErrorResponseMessage("notes not saved", HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}
//	
//	@GetMapping("getAllnotes")
//	public ResponseEntity<?> getAllNotes(){
//		
//		List<NotesDto> allNotes = this.notesService.getAll();
//		
//		if(CollectionUtils.isEmpty(allNotes)) {
//			return ResponseEntity.noContent().build();
//		}
//		
//		return CommonUtils.createBuildResponseMessage("All notes", HttpStatus.OK);
//	}
	
	@Autowired
	private NotesService notesService;

	@PostMapping("/")
	public ResponseEntity<?> saveNotes(@RequestBody NotesDto notesDto) throws Exception {
		Boolean saveNotes = notesService.saveNotes(notesDto);
		if (saveNotes) {
			return CommonUtils.createBuildResponseMessage("Notes saved success", HttpStatus.CREATED);
		}
		return CommonUtils.createErrorResponseMessage("Notes not saved", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllNotes() {
		List<NotesDto> notes = notesService.getAllNotes();
		if (CollectionUtils.isEmpty(notes)) {
			return ResponseEntity.noContent().build();
		}
		return CommonUtils.createBuildResponse(notes, HttpStatus.OK);
	}

	
}
