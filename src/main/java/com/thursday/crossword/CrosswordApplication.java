package com.thursday.crossword;

import com.thursday.crossword.model.db.Clue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrosswordApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrosswordApplication.class, args);

//		var template = new JdbcTemplate();
//		var output = template.queryForObject("SELECT * FROM clues;", Clue.class);
	}

}
