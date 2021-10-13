package chessGame;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    @Override
    public boolean validMove(int newRow, int newColumn) {
        if (!super.validMove(newRow, newColumn)) {
            return false;
        }
        return this.column == newColumn &&
                ((this.isWhite && (newRow == this.row + 1 || (this.row == 2 && newRow == 4))) ||
                        (!this.isWhite && (newRow == this.row - 1 || (this.row == 7 && newRow == 5))));
    }

    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return (this.column == newColumn + 1 || this.column == newColumn - 1) &&
                ((this.row + 1 == newRow && this.isWhite) || (this.row - 1 == newRow && !this.isWhite));
    }

    public List<Integer> placesPassed (int newRow, int newColumn) {
        List<Integer> fieldsPassed = new ArrayList<>();
        if (this.column == newColumn) {
            if (this.isWhite) {
                for (int i = this.row + 1; i <= newRow; i++) {
                    fieldsPassed.add(i * 10 + newColumn);
                }
            } else {
                for (int i = this.row - 1; i >= newRow; i--) {
                    fieldsPassed.add(i * 10 + newColumn);
                }
            }
        }
        return fieldsPassed;
    }

    @Override
    public String toString() {
        if (isWhite) {
            return "\u2659";
        } else {
            return "\u265F";
        }
    }
}
