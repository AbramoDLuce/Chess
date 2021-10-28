package chess.io;

import chess.game.board.Board;

public class SavedGame {
    private String gameName;
    private String date;
    private Board game;

    public SavedGame(String gameName, String date, Board game) {
        this.gameName = gameName;
        this.date = date;
        this.game = game;
    }

    public String getGameName() {
        return gameName;
    }

    public String getDate() {
        return date;
    }

    public Board getGame() {
        return game;
    }
}