package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    // Creating a new queen
    public Queen(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    // The queen can move vertically, horizontally and diagonally, as far as she desires
    @Override
    public boolean validMove(int newRow, int newColumn) {
        if (!super.validMove(newRow, newColumn)) {
            return false;
        }
        return this.column - newColumn == this.row - newRow || newColumn - this.column == this.row - newRow ||
                this.column == newColumn || this.row == newRow;
    }

    // A valid move is a valid capture for the queen
    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return validMove(newRow, newColumn);
    }

    // All places passed with the same row, column or diagonal
    @Override
    public List<Integer> placesPassed (int newRow, int newColumn) {
        List<Integer> fieldsPassed = new ArrayList<>();
        if (this.row == newRow) {
            if (newColumn > this.column) {
                for (int i = this.column + 1; i < newColumn; i++) {
                    fieldsPassed.add(newRow * 10 + i);
                }
            } else {
                for (int i = this.column - 1; i > newColumn; i--) {
                    fieldsPassed.add(newRow * 10 + i);
                }
            }
        } else if (this.column == newColumn){
            if (newRow > this.row) {
                for (int i = this.row + 1; i < newRow; i++) {
                    fieldsPassed.add(i * 10 + newColumn);
                }
            } else {
                for (int i = this.row - 1; i > newRow; i--) {
                    fieldsPassed.add(i * 10 + newColumn);
                }
            }
        } else if (newRow > this.row) {
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
