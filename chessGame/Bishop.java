package chessGame;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    @Override
    public boolean validMove(int newRow, int newColumn) {
        if (!super.validMove(newRow, newColumn)) {
            return false;
        }
        return this.column - newColumn == this.row - newRow || newColumn - this.column == this.row - newRow;
    }

    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return validMove(newRow, newColumn);
    }

    @Override
    public List<Integer> placesPassed (int newRow, int newColumn) {
        List<Integer> fieldsPassed = new ArrayList<>();
        if (newRow > this.row) {
            if (newColumn > this.column) {
                for (int i = 1; i < newRow - this.row; i++) {
                    fieldsPassed.add((this.row + i) * 10 + this.column + i);
                }
            } else {
                for (int i = 1; i < newRow - this.row; i++) {
                    fieldsPassed.add((this.row + i) * 10 + this.column - i);
                }
            }
        } else {
            if (newColumn > this.column) {
                for (int i = 1; i < this.row - newRow; i++) {
                    fieldsPassed.add((this.row - i) * 10 + this.column + i);
                }
            } else {
                for (int i = 1; i < this.row - newRow; i++) {
                    fieldsPassed.add((this.row - i) * 10 + this.column - i);
                }
            }
        }
        return fieldsPassed;
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "\u2657";
        } else {
            return "\u265D";
        }
    }
}
