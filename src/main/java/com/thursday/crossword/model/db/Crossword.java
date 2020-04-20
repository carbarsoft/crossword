package com.thursday.crossword.model.db;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Crossword {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    @NotNull
    private int size;

    @Column
    @OneToMany(mappedBy = "crossword")
    private List<ClueUsage> clueUsages;

    @Column
    private boolean ready;

    public void setSize(int size) { this.size = size; }
}