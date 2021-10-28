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
import java.util.ArrayList;
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

    List<SavedGame> savedGames = new ArrayList<>();
    private String gameToLoad = null;

    public void initialize() {
        updateTableView();
    }

    @FXML
    public void onSaveTableClicked() {
        int row = tableSavedGames.getSelectionModel().getSelectedIndex();
        String name;
        try {
            SavedGame game = tableSavedGames.getItems().get(row);
            name = game.getGameName();
        } catch (IndexOutOfBoundsException e) {
            name ="";
        }
        txtGameName.setText(name);
    }

    @FXML
    public void onLoadTableClicked() {
        int row = tableSavedGames.getSelectionModel().getSelectedIndex();
        String name;
        try {
            SavedGame game = tableSavedGames.getItems().get(row);
            name = game.getGameName();
        } catch (IndexOutOfBoundsException e) {
            name ="";
        }
        gameToLoad = name;
    }

    String getNameGame() {
        return txtGameName.getText();
    }

    String getGameToLoad() {
        return gameToLoad;
    }


    private void updateTableView() {
        List<SavedGame> savedGames = DataAccess.loadAllGames();
        ObservableList<SavedGame> obsSavedGames = FXCollections.observableArrayList(savedGames);
        columnGameName.setCellValueFactory(new PropertyValueFactory<>("gameName"));
        columnDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableSavedGames.setItems(obsSavedGames);
    }
}
