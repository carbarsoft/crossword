package com.thursday.crossword.controller;

import com.thursday.crossword.model.db.Clue;
import com.thursday.crossword.repository.CluesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public @ResponseBody Clue postClue(String clueText, String answer) {
        Clue clue = new Clue();
        clue.setText(clueText);
        clue.setAnswer(answer);
        cluesRepository.save(clue);
        return clue;
    }
}
