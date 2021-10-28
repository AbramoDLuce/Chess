package chess.gui;

import chess.io.DataAccess;
import chess.io.SavedGame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class SaveLoadController {

    @FXML
    TextField txtGameName;
    @FXML
    TableView<SavedGame> tableSavedGames;
    @FXML
    TableColumn<SavedGame, String> columnGameName;
    @FXML
    TableColumn<SavedGame, LocalDate> columnDate;

    private String gameToLoad = null;

    public void initialize() {
        updateTableView();
    }

    // Activates method to save the selected game
    @FXML
    public void onSaveTableClicked() {
        int row = tableSavedGames.getSelectionModel().getSelectedIndex();
        String name;
        try {
            SavedGame game = tableSavedGames.getItems().get(row);
            name = game.getGameName();
            txtGameName.setText(name);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No valid row selected");
        }
    }

    // Activates method to load the selected game
    @FXML
    public void onLoadTableClicked() {
        int row = tableSavedGames.getSelectionModel().getSelectedIndex();
        String name;
        try {
            SavedGame game = tableSavedGames.getItems().get(row);
            name = game.getGameName();
            gameToLoad = name;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No valid row selected");
        }
    }

    // Returns the name of the game to save
    String getSaveGameName() {
        return txtGameName.getText();
    }

    // Returns the name of the game to load
    String getGameToLoad() {
        return gameToLoad;
    }

    // Updates table with game to show all saved games
    private void updateTableView() {
        List<SavedGame> savedGames = DataAccess.loadAllGames();
        ObservableList<SavedGame> obsSavedGames = FXCollections.observableArrayList(savedGames);
        columnGameName.setCellValueFactory(new PropertyValueFactory<>("gameName"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableSavedGames.setItems(obsSavedGames);
    }
}
