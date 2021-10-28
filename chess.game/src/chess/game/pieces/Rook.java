package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    // Creating a new rook
    public Rook(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    // The rook can move as far as it wants within the same row or column
    @Override
    public boolean validMove(int newRow, int newColumn) {
        if(!super.validMove(newRow, newColumn)) {
            return false;
        }
        return this.column == newColumn || this.row == newRow;
    }

    // A valid move is a valid capture for the rook
    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return validMove(newRow, newColumn);
    }

    // The rook will pass through all the fields between the initial position and the final position
    // These positions will always be in the same row or column
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
        } else {
            if (newRow > this.row) {
                for (int i = this.row + 1; i < newRow; i++) {
                    fieldsPassed.add(i * 10 + newColumn);
                }
            } else {
                for (int i = this.row - 1; i > newRow; i--) {
                    fieldsPassed.add(i * 10 + newColumn);
                }
            }
        }
        return fieldsPassed;
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "♖";
        } else {
            return "♜";
        }
    }
}
