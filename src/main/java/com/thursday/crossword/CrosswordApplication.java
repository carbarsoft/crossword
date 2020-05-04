package com.thursday.crossword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrosswordApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrosswordApplication.class, args);

//		var template = new JdbcTemplate();
//		var output = template.queryForObject("SELECT * FROM clues;", Clue.class);
	}

}
