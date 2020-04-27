package com.thursday.crossword.repository;


import com.thursday.crossword.model.db.Clue;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CluesRepository extends CrudRepository<Clue, Integer> {
    @Query(value="SELECT * FROM clue")
    public List<Clue> answerMatcher(String likeString);
}
