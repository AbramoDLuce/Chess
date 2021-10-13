package chessGame;

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

    public boolean validMove(int newRow, int newColumn) {
        if (newRow < 1 || newRow > 8 || newColumn < 1 || newColumn > 8) {
            return false;
        }
        return this.row != newRow || this.column != newColumn;
    }

    public void updateRowAndColumn(int newRow, int newColumn) {
        this.row = newRow;
        this.column = newColumn;
    }

    public abstract boolean validCapture(int newRow, int newColumn);

    public abstract List<Integer> placesPassed(int newRow, int newColumn);

    @Override
    public abstract String toString();
}
