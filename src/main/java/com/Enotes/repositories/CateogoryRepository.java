package com.Enotes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Enotes.entities.Cateogory;

public interface CateogoryRepository extends JpaRepository<Cateogory, Integer>{

	List<Cateogory> findByIsActiveTrue();

}
