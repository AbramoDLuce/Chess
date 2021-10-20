package chess.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PromotionController {

    private Button piece;

    @FXML
    public void btnClicked(ActionEvent event) {
        piece = (Button) event.getSource();
        piece.setStyle("-fx-background-color: #999999; -fx-font-size: 34px");

    }

    public Button getPiece() {
        return piece;
    }
}
