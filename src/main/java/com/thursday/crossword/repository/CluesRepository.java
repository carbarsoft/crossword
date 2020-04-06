package com.thursday.crossword.repository;


import com.thursday.crossword.model.db.Clue;
import org.springframework.data.repository.CrudRepository;

public interface CluesRepository extends CrudRepository<Clue, Integer> {

}
