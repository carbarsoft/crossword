package com.thursday.crossword.model;

import com.thursday.crossword.viewModel.CrosswordViewModel;

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

    public int getId() { return id; }

    public void setSize(int size) { this.size = size; }
    public int getSize() { return size; }

    public List<ClueUsage> getClueUsages() { return clueUsages; }
}