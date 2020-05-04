package com.thursday.crossword.controller;

import com.thursday.crossword.model.db.Clue;
import com.thursday.crossword.repository.CluesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("clues")
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
        clue.setAnswer(answer.toLowerCase());
        cluesRepository.save(clue);
        return clue;
    }

    @GetMapping("/search")
    public @ResponseBody List<Clue> searchAnswers(@RequestParam String searchString) {
        String lowercase = searchString.toLowerCase();
        String regex = convertToRegex(lowercase);
        return cluesRepository.answerMatcher(regex);
    }

    private String convertToRegex(String searchString) {
        return "a%";
    }
}
