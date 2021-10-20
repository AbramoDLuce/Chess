package chess.game.pieces;

import java.util.LinkedList;
import java.util.List;

public class King extends Piece{

    // Creating a new King
    public King(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    // The king can only move to a neighbouring position, but in all directions (horizontally, vertically or diagonally)
    @Override
    public boolean validMove(int newRow, int newColumn) {
        if(!super.validMove(newRow, newColumn)) {
            return false;
        }
        return this.column - newColumn <= 1 && this.column - newColumn >= -1 && this.row - newRow <= 1 && this.row - newRow >= -1;
    }

    // A valid move is a valid capture for the king
    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return validMove(newRow, newColumn);
    }

    // As the king can only move to a neighbouring position, it will not pass through any other fields
    @Override
    public List<Integer> placesPassed(int newRow, int newColumn) {
        return new LinkedList<>();
    }
}
