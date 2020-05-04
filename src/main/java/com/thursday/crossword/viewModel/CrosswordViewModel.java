package com.thursday.crossword.viewModel;

import com.thursday.crossword.enumerable.Direction;
import com.thursday.crossword.exception.ClueCollisionException;
import com.thursday.crossword.model.Crossword;

import java.util.List;
import java.util.Optional;

public class CrosswordViewModel {
    private int id;
    private int size;
    private boolean ready;

    private List<PopulatedCell> cells;

    public int getId() { return id; }
    public int getSize() { return size; }
    public boolean isReady() { return ready; }

    public List<PopulatedCell> getCells() { return cells; }

    public CrosswordViewModel(Crossword crossword) throws ClueCollisionException {
        crossword.getClueUsages().forEach(clue -> {
            int startX = clue.getStartingX();
            int startY = clue.getStartingY();
            Direction dir = clue.getDirection();
            String answer = clue.getClue().getAnswer();

            for(int i = 0; i<answer.length(); i++) {
                char character = answer.charAt(i);
                PopulatedCell newCell;
                if(dir == Direction.ACROSS) {
                    int newX = startX + i;
                    newCell = new PopulatedCell(character, newX, startY);
                } else {
                    int newY = startY + i;
                    newCell = new PopulatedCell(character, startX, newY);
                }

                Optional<PopulatedCell> collision = this.cells.stream().filter(cell -> cell.getXpos() == newCell.getXpos() && cell.getYpos() == newCell.getYpos()).findAny();
                if(collision.isEmpty()) {
                    this.cells.add(newCell);
                } else if(collision.get().getValue() != newCell.getValue()) {
                    throw new ClueCollisionException();
                }
            }
        });
    }
}

class PopulatedCell {
    private char value;
    private int xpos;
    private int ypos;

    public char getValue() { return value; }
    public int getXpos() { return xpos; }
    public int getYpos() { return ypos; }

    PopulatedCell(char value, int xpos, int ypos) {
        this.value = value;
        this.xpos = xpos;
        this.ypos = ypos;
    }
}
