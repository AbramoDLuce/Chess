package chess.io;

import chess.game.board.Board;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {

    // Saves a game with a specific name. If the name already exists, it will overwrite the previous game.
    public static void saveGame(String gameName, Board game) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(gameName + ".dat"))) {
            outputStream.writeObject(game);
        } catch (IOException e) {
            System.out.println("Could not save game: " + e.getMessage());
        }
    }

    // Returns the chosen game from the list of saved games
    public static Board loadGame(String gameName) {
        List<SavedGame> games = loadAllGames();
        for (SavedGame game : games) {
            if (game.getGameName().equals(gameName)) {
                return game.getGame();
            }
        }
        return new Board();
    }

    // Fetches all previously saved games and returns them as a list
    public static List<SavedGame> loadAllGames() {
        String directoryPath = new File("").getAbsolutePath();
        File directory = new File(directoryPath);
        File[] fileList = directory.listFiles();
        List<File> savedGameFiles = new ArrayList<>();
        List<SavedGame> savedGames = new ArrayList<>();
        try {
            for (File file : fileList) {
                if (file.getAbsolutePath().endsWith(".dat")) {
                    savedGameFiles.add(file);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No files in directory: " + e.getMessage());
        }
        if (!savedGameFiles.isEmpty()) {
            for (File file : savedGameFiles) {
                String savedGamePath = file.getAbsolutePath();
                Path path = Paths.get(savedGamePath);
                try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(savedGamePath))) {
                    FileTime dateSaved = Files.getLastModifiedTime(path);
                    LocalDate fileDate = dateSaved.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    String savedGameDate = fileDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
                    int fileNameStartIndex;
                    if (savedGamePath.contains("/")) {
                        fileNameStartIndex = savedGamePath.lastIndexOf("/") + 1;
                    } else {
                        fileNameStartIndex = savedGamePath.lastIndexOf("\\") + 1;
                    }
                    String savedGameName = savedGamePath.substring(fileNameStartIndex, savedGamePath.length() - 4);
                    Board board = (Board) inputStream.readObject();
                    SavedGame game = new SavedGame(savedGameName, savedGameDate, board);
                    savedGames.add(game);
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Problem loading game: " + e.getMessage());
                }
            }
        }
        return savedGames;
    }
}
