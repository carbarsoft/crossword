package com.thursday.crossword.model.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

enum Direction {
    ACROSS,
    DOWN,
}

@Entity
@Table
public class ClueUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    @NotNull
    private Direction direction;

    @Column
    @NotNull
    private int startingX;
    
    @Column
    @NotNull
    private int startingY;

    @ManyToOne
    @JoinColumn(name="clue_id")
    private Clue clue;

    @ManyToOne
    @JoinColumn(name="crossword_id")
    private Crossword crossword;
}