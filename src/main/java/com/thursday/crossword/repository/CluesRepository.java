package com.thursday.crossword.repository;


import com.thursday.crossword.model.db.Clue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CluesRepository extends CrudRepository<Clue, Integer> {
    @Query(value="SELECT c FROM Clue AS c WHERE c.answer LIKE :likeString")
    List<Clue> answerMatcher(String likeString);
}
