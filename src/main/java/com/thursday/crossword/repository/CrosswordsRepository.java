package com.thursday.crossword.repository;


import com.thursday.crossword.model.Crossword;
import org.springframework.data.repository.CrudRepository;

public interface CrosswordsRepository extends CrudRepository<Crossword, Integer> {

}
