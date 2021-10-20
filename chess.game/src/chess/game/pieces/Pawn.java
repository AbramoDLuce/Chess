package chess.game.pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    // Creating a new pawn
    public Pawn(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
    }

    // Pawns can move only one position forward at a time, except for the first move, which can be two positions
    @Override
    public boolean validMove(int newRow, int newColumn) {
        if (!super.validMove(newRow, newColumn)) {
            return false;
        }
        return this.column == newColumn &&
                ((this.isWhite && (newRow == this.row + 1 || (this.row == 2 && newRow == 4))) ||
                        (!this.isWhite && (newRow == this.row - 1 || (this.row == 7 && newRow == 5))));
    }

    // A pawn can only capture one position diagonally forward (this is also true for en passant)
    @Override
    public boolean validCapture(int newRow, int newColumn) {
        return (this.column == newColumn + 1 || this.column == newColumn - 1) &&
                ((this.row + 1 == newRow && this.isWhite) || (this.row - 1 == newRow && !this.isWhite));
    }

    // To avoid invalid capture, the destination position is also included for the pawns
    // A pawn will only pass one (the destination) or, in case of the initial move, two fields (the destination and the
    // one field in between the initial position and the destination.
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
}
