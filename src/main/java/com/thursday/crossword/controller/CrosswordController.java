package com.thursday.crossword.controller;

import com.thursday.crossword.model.db.Crossword;
import com.thursday.crossword.repository.CrosswordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("crosswords")
public class CrosswordController {

    @Autowired
    private CrosswordsRepository crosswordsRepository;

    CrosswordController(CrosswordsRepository crosswordsRepository) {
        this.crosswordsRepository = crosswordsRepository;
    }

    @GetMapping
    public @ResponseBody Iterable<Crossword> getAll() {
        return crosswordsRepository.findAll();
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public @ResponseBody Crossword postCrossword(int size) {
        Crossword crossword = new Crossword();
        crossword.setSize(size);
        crosswordsRepository.save(crossword);
        return crossword;
    }
}
