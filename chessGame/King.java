package chessGame;

import java.util.LinkedList;
import java.util.List;

public class King extends Piece{

    public King(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    @Override
    public boolean validMove(int newRow, int newColumn) {
        if(!super.validMove(newRow, newColumn)) {
            return false;
        }
        return this.column - newColumn <= 1 && this.column - newColumn >= -1 && this.row - newRow <= 1 && this.row - newRow >= -1;
    }

    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return validMove(newRow, newColumn);
    }

    @Override
    public List<Integer> placesPassed(int newRow, int newColumn) {
        return new LinkedList<>();
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "\u2654";
        } else {
            return "\u265A";
        }
    }
}
