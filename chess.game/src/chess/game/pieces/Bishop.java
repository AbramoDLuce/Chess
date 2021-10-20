package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    // Creating a new bishop
    public Bishop(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    // The bishop can move as far as it wants diagonally over the board
    @Override
    public boolean validMove(int newRow, int newColumn) {
        if (!super.validMove(newRow, newColumn)) {
            return false;
        }
        return this.column - newColumn == this.row - newRow || newColumn - this.column == this.row - newRow;
    }

    // A valid move is a valid capture for the bishop
    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return validMove(newRow, newColumn);
    }

    // The bishop will pass through all the fields between the initial position and the final position
    // These positions will always be on the same diagonal
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
}
