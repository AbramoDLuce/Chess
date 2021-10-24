package chess.game.pieces;

import java.util.List;

public abstract class Piece {
    protected int row;
    protected int column;
    protected boolean isWhite;

    public Piece(int row, int column, boolean isWhite) {
        this.row = row;
        this.column = column;
        this.isWhite = isWhite;
    }

    // General check to see if the move is within the constraints of the board
    public boolean validMove(int newRow, int newColumn) {
        if (newRow < 1 || newRow > 8 || newColumn < 1 || newColumn > 8) {
            return false;
        }
        return this.row != newRow || this.column != newColumn;
    }

    // Updates the position of the piece
    public void setRowAndColumn(int newRow, int newColumn) {
        this.row = newRow;
        this.column = newColumn;
    }

    // Verifies the capture is legal
    public abstract boolean validCapture(int newRow, int newColumn);

    // Returns a list of positions through which the moving piece must have passed to reach the destination,
    // excluding the initial position and the final position
    // This is important for verifying the way was not obstructed by other pieces
    public abstract List<Integer> placesPassed(int newRow, int newColumn);

    public boolean isWhite() {
        return isWhite;
    }
}
