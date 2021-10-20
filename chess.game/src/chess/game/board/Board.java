package chess.game.board;

import chess.game.pieces.*;

import java.util.*;

// Putting a piece in between to solve check, but by moving that piece it would be 'check' from another line -> in case of a checkmate, not implemented yet
// In stalemate check if a piece cannot move, because it would result in a check, not implemented yet

public class Board {
    private final Map<Integer, Boolean> field;
    private final Map<Integer, Piece> pieces;
    private boolean whitesTurn;
    private int actionNumber = -1;
    private final List<String> actionHistory = new ArrayList<>();
    private int positionWhiteKing = 15;
    private int positionBlackKing = 85;

    // Creating chess board with all the pieces on it
    public Board() {
        // Creating chess board with indication of which fields are occupied by a piece (true) and which fields are empty (false)
        // Hashmap key is the location in which the first digit is the row and the second digit the column (e.g. position 45 is row 4 column 5 (column E))
        field = new LinkedHashMap<>();
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                field.put(i * 10 + j, (i <= 2 || i >= 7));
            }
        }

        // Creating all the chess pieces and giving them the location on the field they occupy
        pieces = new HashMap<>();
        // Creating white pieces
        pieces.put(11, new Rook(1, 1, true));
        pieces.put(12, new Knight(1, 2, true));
        pieces.put(13, new Bishop(1, 3, true));
        pieces.put(14, new Queen(1, 4, true));
        pieces.put(15, new King(1, 5, true));
        pieces.put(16, new Bishop(1, 6, true));
        pieces.put(17, new Knight(1, 7, true));
        pieces.put(18, new Rook(1, 8, true));

        for (int j = 1; j <= 8; j++) {
            //creating all the white pawns
            pieces.put(20 + j, new Pawn(2, j, true));
            //creating all the black pawns
            pieces.put(70 + j, new Pawn(7, j, false));

        }
        // Creating all the remaining black pieces
        pieces.put(81, new Rook(8, 1, false));
        pieces.put(82, new Knight(8, 2, false));
        pieces.put(83, new Bishop(8, 3, false));
        pieces.put(84, new Queen(8, 4, false));
        pieces.put(85, new King(8, 5, false));
        pieces.put(86, new Bishop(8, 6, false));
        pieces.put(87, new Knight(8, 7, false));
        pieces.put(88, new Rook(8, 8, false));

        whitesTurn = true;
    }

    // Moving pieces on the board after testing if it is possible to do this.
    // Returns true if the move was successful.
    public boolean movePiece(int oldPlace, int newPlace) {
        int newColumn = newPlace % 10;
        int newRow = newPlace / 10;
        // Tests if it is the turn of the player trying to move the piece
        if (field.get(oldPlace) && pieces.get(oldPlace).isWhite() == whitesTurn) {
            // Tests if an attempt on castling was made
            if (castling(oldPlace, newPlace)) {
                return true;
            }
            // Tests if there are no pieces in between the old and new position, preventing the move
            for (Integer position : pieces.get(oldPlace).placesPassed(newRow, newColumn)) {
                if (field.get(position)) {
                    System.out.println("Invalid move");
                    return false;
                }
            }
            // Tests if the new position is not occupied by a piece of the same color.
            if (field.get(newPlace)) {
                if (pieces.get(oldPlace).isWhite() == pieces.get(newPlace).isWhite()) {
                    System.out.println("Invalid move");
                    return false;
                }
            }
            if (regularMove(oldPlace, newPlace)) {
                return true;
            }
            if (captureWithPawn(oldPlace, newPlace)) {
                return true;
            }
        }
        System.out.println("Invalid move");
        return false;
    }

    // Tests if a specific piece can make this specific move. This is only used for the standard moves and excludes castling and en passant.
    private boolean regularMove(int oldPlace, int newPlace) {
        int oldColumn = oldPlace % 10;
        int oldRow = oldPlace / 10;
        int newColumn = newPlace % 10;
        int newRow = newPlace / 10;
        if (pieces.get(oldPlace).validMove(newRow, newColumn)) {
            // When moving a piece, the new position of the pieces must be tested for check, so the player cannot move its own king in a check position.
            if (pieces.get(oldPlace) instanceof King) {
                placeKing(newPlace);
            }
            // Placing the piece in the new position and updating the board and piece
            Piece removedPiece = pieces.get(newPlace);
            pieces.get(oldPlace).updateRowAndColumn(newRow, newColumn);
            field.put(oldPlace, false);
            field.put(newPlace, true);
            pieces.put(newPlace, pieces.get(oldPlace));
            pieces.remove(oldPlace);
            // Testing if this results in a check, and if so, placing the pieces back in their original place
            if (check(whitesTurn).length() > 0) {
                pieces.put(oldPlace, pieces.get(newPlace));
                pieces.remove(newPlace);
                field.put(oldPlace, true);
                pieces.get(oldPlace).updateRowAndColumn(oldRow, oldColumn);
                if (pieces.get(oldPlace) instanceof King) {
                    placeKing(oldPlace);
                }
                // Putting a removed piece back on the board, after it was verified that the move resulted in a check
                if (removedPiece != null) {
                    pieces.put(newPlace, removedPiece);
                } else {
                    field.put(newPlace, false);
                }
                System.out.println("Invalid move");
                return false;
            }
            // changing players turn
            whitesTurn = !whitesTurn;
            actionNumber++;
            // Adding the move to the action history
            actionHistory.add(intToLetterConverter(oldColumn) + oldRow + "-" + intToLetterConverter(newColumn) + newRow);
            return true;
        }
        return false;
    }

    // Testing if an attempt is made to capture a piece with a pawn
    private boolean captureWithPawn(int oldPlace, int newPlace) {
        int oldColumn = oldPlace % 10;
        int oldRow = oldPlace / 10;
        int newColumn = newPlace % 10;
        int newRow = newPlace / 10;
        if (pieces.get(oldPlace) instanceof Pawn) {
            if (field.get(newPlace) && pieces.get(oldPlace).validCapture(newRow, newColumn)) {
                // Updating board and pieces
                Piece removedPiece = pieces.get(newPlace);
                pieces.get(oldPlace).updateRowAndColumn(newRow, newColumn);
                field.put(oldPlace, false);
                pieces.put(newPlace, pieces.get(oldPlace));
                pieces.remove(oldPlace);
                if (check(whitesTurn).length() > 0) {
                    // Repositioning pieces after the move has resulted in a check
                    pieces.put(oldPlace, pieces.get(newPlace));
                    pieces.remove(newPlace);
                    pieces.put(newPlace, removedPiece);
                    field.put(oldPlace, true);
                    pieces.get(oldPlace).updateRowAndColumn(oldRow, oldColumn);
                    System.out.println("Invalid move");
                    return false;
                }

                whitesTurn = !whitesTurn;
                actionNumber++;
                actionHistory.add(intToLetterConverter(oldColumn) + oldRow + "-" + intToLetterConverter(newColumn) + newRow);
                return true;
            }
            return enPassant(oldPlace, newPlace);
        }
        return false;
    }

    // Performs the 'en passant' move and removes the captured piece
    private boolean enPassant(int oldPlace, int newPlace) {
        int oldColumn = oldPlace % 10;
        int oldRow = oldPlace / 10;
        int newColumn = newPlace % 10;
        int newRow = newPlace / 10;
        if (!actionHistory.isEmpty()) {
            String lastAction = actionHistory.get(actionNumber);
            if (((lastAction.equals(intToLetterConverter(newColumn) + 2 + "-" + intToLetterConverter(newColumn) + oldRow)) ||
                    (lastAction.equals(intToLetterConverter(newColumn) + 7 + "-" + intToLetterConverter(newColumn) + oldRow))) &&
                    (oldRow == 4 || oldRow == 5)) {
                if (pieces.get(oldPlace).validCapture(newRow, newColumn)) {
                    // updating pieces and board
                    Piece removedPiece = pieces.get(oldRow * 10 + newColumn);
                    pieces.get(oldPlace).updateRowAndColumn(newRow, newColumn);
                    field.put(oldPlace, false);
                    field.put(newPlace, true);
                    field.put(oldRow * 10 + newColumn, false);
                    pieces.put(newPlace, pieces.get(oldPlace));
                    pieces.remove(oldPlace);
                    pieces.remove(oldRow * 10 + newColumn);
                    // Cancels move after it was confirmed the move results in check
                    if (check(whitesTurn).length() > 0) {
                        pieces.put(oldRow * 10 + newColumn, removedPiece);
                        pieces.put(oldPlace, pieces.get(newPlace));
                        pieces.remove(newPlace);
                        field.put(oldRow * 10 + newColumn, true);
                        field.put(newPlace, false);
                        field.put(oldPlace, true);
                        pieces.get(oldPlace).updateRowAndColumn(oldRow, oldColumn);
                        System.out.println("Invalid move");
                        return false;
                    }
                    whitesTurn = !whitesTurn;
                    actionNumber++;
                    actionHistory.add(intToLetterConverter(oldColumn) + oldRow + "-" + intToLetterConverter(newColumn) + newRow);
                    return true;
                }
            }
        }
        return false;
    }

    // Performs the castling move that affects both king and rook
    private boolean castling(int oldPlace, int newPlace) {
        int oldColumn = oldPlace % 10;
        int oldRow = oldPlace / 10;
        int newColumn = newPlace % 10;
        int newRow = newPlace / 10;
        if ((oldPlace == 15 && (newPlace == 17 || newPlace == 13)) || (oldPlace == 85 && (newPlace == 87 || newPlace == 83))) {
            // Tests if castling is possible
            if (isCastlingAllowed(oldRow, oldColumn, newRow, newColumn)) {
                // Updates the occupied places on the board and the actual position of the pieces
                pieces.put(newPlace, pieces.get(oldPlace));
                pieces.remove(oldPlace);
                pieces.get(newPlace).updateRowAndColumn(newRow, newColumn);
                placeKing(newPlace);
                field.put(newPlace, true);
                field.put(oldPlace, false);
                if (newColumn > oldColumn) {
                    pieces.put(oldRow * 10 + 6, pieces.get(oldRow * 10 + 8));
                    pieces.remove(oldRow * 10 + 8);
                    pieces.get(oldRow * 10 + 6).updateRowAndColumn(oldRow, 6);
                    field.put(oldRow * 10 + 6, true);
                    field.put(oldRow * 10 + 8, false);
                } else {
                    pieces.put(oldRow * 10 + 4, pieces.get(oldRow * 10 + 1));
                    pieces.remove(oldRow * 10 + 1);
                    pieces.get(oldRow * 10 + 4).updateRowAndColumn(oldRow, 6);
                    field.put(oldRow * 10 + 4, true);
                    field.put(oldRow * 10 + 1, false);
                }
                whitesTurn = !whitesTurn;
                actionNumber++;
                actionHistory.add(intToLetterConverter(oldColumn) + oldRow + "-" + intToLetterConverter(newColumn) + newRow);
                return true;
            }
        }
        return false;
    }

    // promoting of a pawn that reached the final row
    public void promote(int newRow, int newColumn, String newPiece) {
        int newPlace = newRow * 10 + newColumn;
        boolean exitLoop = false;
        while (!exitLoop) {
            switch (newPiece) {
                case "♖":
                case "♜":
                    pieces.put(newPlace, new Rook(newRow, newColumn, pieces.get(newPlace).isWhite()));
                    exitLoop = true;
                    break;
                case "♘":
                case "♞":
                    pieces.put(newPlace, new Knight(newRow, newColumn, pieces.get(newPlace).isWhite()));
                    exitLoop = true;
                    break;
                case "♗":
                case "♝":
                    pieces.put(newPlace, new Bishop(newRow, newColumn, pieces.get(newPlace).isWhite()));
                    exitLoop = true;
                    break;
                case "♕":
                case "♛":
                    pieces.put(newPlace, new Queen(newRow, newColumn, pieces.get(newPlace).isWhite()));
                    exitLoop = true;
                    break;
                default:
                    exitLoop = true;
                    break;
            }
        }
    }

    // Checks by which pieces the king is check
    // Returns a string with all positions that put the king check (e.g. if position E3 and D7 put the king check the string is 3574)
    public String check(boolean isWhite) {
        int kingRow;
        int kingColumn;
        StringBuilder checkByPosition = new StringBuilder();
        if (isWhite) {
            kingRow = positionWhiteKing / 10;
            kingColumn = positionWhiteKing % 10;
        } else {
            kingRow = positionBlackKing / 10;
            kingColumn = positionBlackKing % 10;
        }
        for (Map.Entry<Integer, Piece> piece : pieces.entrySet()) {
            if (piece.getValue().validCapture(kingRow, kingColumn) && piece.getValue().isWhite() != isWhite) {
                boolean isCheck = true;
                for (Integer position : piece.getValue().placesPassed(kingRow, kingColumn)) {
                    if (field.get(position)) {
                        isCheck = false;
                    }
                }
                if (isCheck) {
                    checkByPosition.append(piece.getKey());
                }
            }
        }
        return checkByPosition.toString();
    }

    // Checks if king is checkmate
    public boolean checkMate(boolean isWhite) {
        int kingRow;
        int kingColumn;
        if (isWhite) {
            kingRow = positionWhiteKing / 10;
            kingColumn = positionWhiteKing % 10;
        } else {
            kingRow = positionBlackKing / 10;
            kingColumn = positionBlackKing % 10;
        }
        if (canKingMove(isWhite, kingRow, kingColumn)) {
            return false;
        }
        if (check(isWhite).length() == 2) {
            int checkByPosition = Integer.parseInt(check(isWhite));
            if (canMovePieceInBetween(isWhite, checkByPosition, kingRow, kingColumn)) {
                return false;
            }
            if (canSolveCheckWithCapture(isWhite, checkByPosition, kingRow, kingColumn)) {
                return false;
            }
        }
        placeKing(isWhite, kingRow, kingColumn);
        return true;
    }

    // Verifies movement possibility of the king.
    // Only possible if own pieces don't block a movement and the available fields are not guarded by the opponent's pieces.
    // Used to verify if moving the king can solve check
    // Returns true if king has options to move
    private boolean canKingMove(boolean isWhite, int kingRow, int kingColumn) {
        for (int i = kingRow - 1; i <= kingRow + 1; i++) {
            for (int j = kingColumn - 1; j <= kingColumn + 1; j++) {
                if (field.get(i * 10 + j) != null) {
                    if (pieces.get(i * 10 + j) != null) {
                        if (pieces.get(i * 10 + j).isWhite() != isWhite) {
                            placeKing(isWhite, i, j);
                            if (check(isWhite).length() < 2) {
                                placeKing(isWhite, kingRow, kingColumn);
                                return true;
                            }
                        }
                    } else {
                        placeKing(isWhite, i, j);
                        if (check(isWhite).length() < 2) {
                            placeKing(isWhite, kingRow, kingColumn);
                            return true;
                        }
                    }
                }
            }
        }
        placeKing(isWhite, kingRow, kingColumn);
        return false;
    }

    // Is used to see if check can be solved by putting a piece in between the king and the piece that causes the check
    private boolean canMovePieceInBetween(boolean isWhite, int checkByPosition, int kingRow, int kingColumn) {
        for (int fieldInBetween : pieces.get(checkByPosition).placesPassed(kingRow, kingColumn)) {
            for (Map.Entry<Integer, Piece> piece : pieces.entrySet()) {
                if (piece.getValue().validMove(fieldInBetween / 10, fieldInBetween % 10) &&
                        piece.getValue().isWhite() == isWhite && !(piece.getValue() instanceof King)) {
                    boolean prevented = false;
                    for (int fieldInBetween2 : piece.getValue().placesPassed(fieldInBetween / 10, fieldInBetween % 10)) {
                        if (field.get(fieldInBetween2)) {
                            prevented = true;
                        }
                    }
                    if (!prevented) {
                        return true;
                    }
                    // verify moving this piece does not result in a new check from the line of the old position (hidden behind the piece in its old position)
                }
            }
        }
        return false;
    }

    // Is used to see if check can be solved by capturing the piece that is attacking the king
    private boolean canSolveCheckWithCapture(boolean isWhite, int checkByPosition, int kingRow, int kingColumn) {
        for (Map.Entry<Integer, Piece> piece : pieces.entrySet()) {
            if (piece.getValue().validCapture(checkByPosition / 10, checkByPosition % 10) && piece.getValue().isWhite() == isWhite) {
                placeKing(isWhite, checkByPosition / 10, checkByPosition % 10);
                if (!(check(isWhite).length() == 2)) {
                    boolean prevented = false;
                    for (int fieldInBetween : piece.getValue().placesPassed(checkByPosition / 10, checkByPosition % 10)) {
                        if (field.get(fieldInBetween)) {
                            prevented = true;
                        }
                    }
                    if (!prevented) {
                        placeKing(isWhite, kingRow, kingColumn);
                        return true;
                    }
                }
                // verify moving this piece does not result in a new check from the line of the old position (hidden behind the piece in its old position)
            }
        }
        return false;
    }

    // Checks if king is stalemate
    public boolean stalemate(boolean isWhite) {
        for (Map.Entry<Integer, Piece> piece : pieces.entrySet()) {
            if (piece.getValue().isWhite() == whitesTurn) {
                if (!(piece.getValue() instanceof King)) {
                    if (canPieceMove(piece.getValue())) {
                        return false;
                    }
                } else {
                    int kingRow;
                    int kingColumn;
                    if (isWhite) {
                        kingRow = positionWhiteKing / 10;
                        kingColumn = positionWhiteKing % 10;
                    } else {
                        kingRow = positionBlackKing / 10;
                        kingColumn = positionBlackKing % 10;
                    }
                    if (canKingMove(isWhite, kingRow, kingColumn)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Checks if the piece has at least one valid move
    private boolean canPieceMove(Piece piece) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (piece.validMove(i, j)) {
                    // must still check if this move results in a check from a piece behind
                    return true;
                }
            }
        }
        return false;
    }

    // Checks if castling is allowed by calling the methods hasKingOrRookMoved and checkDuringCastling
    private boolean isCastlingAllowed(int oldRow, int oldColumn, int newRow, int newColumn) {
        if (oldRow != newRow) {
            return false;
        }
        if (whitesTurn) {
            if (newColumn == oldColumn + 2) {
                if (hasKingOrRookMoved("E1", "H1")) {
                    return false;
                }
                if (field.get(16) || field.get(17)) {
                    return false;
                }
                if (checkDuringCastling(17, positionWhiteKing)) {
                    positionWhiteKing = 15;
                    return false;
                }
            } else if (newColumn == oldColumn - 2) {
                if (hasKingOrRookMoved("E1", "A1")) {
                    return false;
                }
                if (field.get(14) || field.get(13) || field.get(12)) {
                    return false;
                }
                if (checkDuringCastling(positionWhiteKing, 13)) {
                    positionWhiteKing = 15;
                    return false;
                }
            } else {
                return false;
            }
            positionWhiteKing = 15;
        } else {
            if (newColumn == oldColumn + 2) {
                if (hasKingOrRookMoved("E8", "H8")) {
                    return false;
                }
                if (field.get(86) || field.get(87)) {
                    return false;
                }
                if (checkDuringCastling(87, positionBlackKing)) {
                    positionBlackKing = 85;
                    return false;
                }
            } else if (newColumn == oldColumn - 2) {
                if (hasKingOrRookMoved("E8", "A8")) {
                    return false;
                }
                if (field.get(84) || field.get(83) || field.get(82)) {
                    return false;
                }
                if (checkDuringCastling(positionBlackKing, 83)) {
                    positionBlackKing = 85;
                    return false;
                }
            } else {
                return false;
            }
            positionBlackKing = 85;
        }
        return true;
    }

    // Checks the history of moves to verify if the king or rook involved in the castling has been moved previously
    private boolean hasKingOrRookMoved(String kingPosition, String rookPosition) {
        for (String action : actionHistory) {
            if (action.contains(kingPosition) || action.contains(rookPosition)) {
                return true;
            }
        }
        return false;
    }

    // Checks if the king passes through a position during castling or ends in a position in which it would be check
    private boolean checkDuringCastling(int kingPos1, int kingPos2) {
        for (int i = kingPos2; i <= kingPos1; i++) {
            placeKing(i);
            if (check(whitesTurn).length() > 0) {
                return true;
            }
        }
        return false;
    }

    // Places the king on a specific position on the board
    private void placeKing(boolean isWhite, int kingRow, int kingColumn) {
        if (isWhite) {
            positionWhiteKing = kingRow * 10 + kingColumn;
        } else {
            positionBlackKing = kingRow * 10 + kingColumn;
        }
    }

    // Places the king on a specific position on the board
    private void placeKing(int position) {
        if (whitesTurn) {
            positionWhiteKing = position;
        } else {
            positionBlackKing = position;
        }
    }

    //Returns the full action history of the game in a readable format. Each line is a move.
    public String getActionHistory() {
        StringBuilder actions = new StringBuilder();
        int actionCounter = 1;
        for (String action : actionHistory) {
            actions.append(actionCounter);
            actions.append(". ");
            actions.append(action);
            if (actionCounter % 2 == 0) {
                actions.append(" (black)");
            } else {
                actions.append(" (white)");
            }
            actions.append("\n");
            actionCounter++;
        }
        return actions.toString();
    }

    // Returns true if it is white's turn and false if it is black's turn
    public boolean getWhitesTurn() {
        return whitesTurn;
    }

    // Converts the column numbers into letters for writing to the history of actions
    private String intToLetterConverter(int number) throws IndexOutOfBoundsException {
        switch (number) {
            case 1:
                return "A";
            case 2:
                return "B";
            case 3:
                return "C";
            case 4:
                return "D";
            case 5:
                return "E";
            case 6:
                return "F";
            case 7:
                return "G";
            case 8:
                return "H";
            default:
                class ColumnIndexOutOfBoundsException extends IndexOutOfBoundsException {
                    public ColumnIndexOutOfBoundsException(String s) {
                        super(s);
                    }
                }
                throw new ColumnIndexOutOfBoundsException("Column number must be between 1 and 9. Column " + number + " invalid.");
        }
    }
}