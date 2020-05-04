package com.thursday.crossword.controller;

import com.thursday.crossword.model.ClueUsage;
import com.thursday.crossword.model.Crossword;
import com.thursday.crossword.repository.CrosswordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/edit")
    public String editCrossword(@RequestParam(name="id") String id, Model model) {
        //TODO: catch error if crossword isn't found
        Crossword crossword = crosswordsRepository.findById(Integer.parseInt(id)).get();
        model.addAttribute("id", id);
        model.addAttribute("size", crossword.getSize());
        return "edit-crossword";
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public @ResponseBody Crossword newCrossword(int size) {
        Crossword crossword = new Crossword();
        crossword.setSize(size);
        crosswordsRepository.save(crossword);
        //TODO: send us to editing this crossword
        return crossword;
    }
}
