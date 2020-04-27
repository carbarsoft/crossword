package com.thursday.crossword.controller;

import com.thursday.crossword.model.db.Clue;
import com.thursday.crossword.repository.CluesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clues")
public class ClueController {

    @Autowired
    private CluesRepository cluesRepository;

    ClueController(CluesRepository cluesRepository) {
        this.cluesRepository = cluesRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Clue> getAll() {
        return cluesRepository.findAll();
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public @ResponseBody Clue postClue(String text, String answer) {
        Clue clue = new Clue();
        clue.setText(text);
        clue.setAnswer(answer);
        cluesRepository.save(clue);
        return clue;
    }
}
