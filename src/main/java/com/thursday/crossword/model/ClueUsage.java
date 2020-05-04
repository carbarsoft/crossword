package com.thursday.crossword.model;

import com.thursday.crossword.enumerable.Direction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    public int getId() { return id; }

    public Direction getDirection() { return direction; }
    public int getStartingX() { return startingX; }
    public int getStartingY() { return startingY; }

    public Clue getClue() { return clue; }
    public Crossword getCrossword() { return crossword; }
}