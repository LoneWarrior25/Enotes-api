package com.Enotes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Enotes.entities.Notes;

public interface NotesRepository extends JpaRepository<Notes, Integer>{

}
