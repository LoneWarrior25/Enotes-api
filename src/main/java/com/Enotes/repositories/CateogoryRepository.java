package com.Enotes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Enotes.entities.Cateogory;

public interface CateogoryRepository extends JpaRepository<Cateogory, Integer>{

	List<Cateogory> findByIsActiveTrueAndIsDeletedFalse();

	Optional<Cateogory> findByIdAndIsDeletedFalse(Integer id);

	List<Cateogory> findByIsDeletedFalse();

}
