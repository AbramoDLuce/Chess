package chess.game.pieces;

import java.util.LinkedList;
import java.util.List;

public class Knight extends Piece {

    // Creating a new knight
    public Knight(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    // Valid moves for the knight are 'L'-shaped, with two moves in one direction and one in the other
    @Override
    public boolean validMove(int newRow, int newColumn) {
        if (!super.validMove(newRow, newColumn)) {
            return false;
        }
        return ((this.row - newRow == 2 || this.row - newRow == -2) && (this.column - newColumn == 1 || this.column - newColumn == -1)) ||
                ((this.row - newRow == 1 || this.row - newRow == -1) && (this.column - newColumn == 2 || this.column - newColumn == -2));
    }

    // A valid move is a valid capture for the knight
    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return validMove(newRow, newColumn);
    }

    // The knight jumps over pieces, so it never really passes through other fields to reach its destination.
    @Override
    public List<Integer> placesPassed(int newRow, int newColumn) {
        return new LinkedList<>();
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "♘";
        } else {
            return "♞";
        }
    }
}
