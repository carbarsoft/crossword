package com.thursday.crossword.controller;

import com.thursday.crossword.model.db.Clue;
import com.thursday.crossword.repository.CluesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String postClue(String text, String answer, Model model) {
        Clue clue = new Clue();
        clue.setText(text);
        clue.setAnswer(answer.toLowerCase());
        cluesRepository.save(clue);
        model.addAttribute("message", "Clue submitted successfully!");
        return "submitClue";
    }

    @GetMapping("/search")
    public @ResponseBody List<Clue> searchAnswers(@RequestParam String searchString) {
        String lowercase = searchString.toLowerCase();
        String regex = convertToRegex(lowercase);
        return cluesRepository.answerMatcher(regex);
    }

    @GetMapping("/submit")
    public String submitCluePage(Model model) {
        model.addAttribute("message","Submit a clue here!");
        return "submitClue";
    }

    private String convertToRegex(String searchString) {
        return searchString.replaceAll("[^a-z]", "_");
    }
}
