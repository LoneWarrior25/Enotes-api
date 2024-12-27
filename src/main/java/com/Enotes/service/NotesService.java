package com.Enotes.service;

import java.util.List;

import com.Enotes.dto.NotesDto;

public interface NotesService {

//	public Boolean save(NotesDto notesDto) throws Exception;

	//public List<NotesDto> getAll();

	public Boolean saveNotes(NotesDto notesDto) throws Exception;
//
	public List<NotesDto> getAllNotes();
}
