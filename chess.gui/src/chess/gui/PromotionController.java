package chess.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

// Controller is used with both white and black promotion fxml files. As for the functionality they operate in the same way
public class PromotionController {

    private Button piece;

    // Shows which button, representing the piece chose of the promotion, has been selected
    @FXML
    public void btnClicked(ActionEvent event) {
        piece = (Button) event.getSource();
        piece.setStyle("-fx-background-color: #999999; -fx-font-size: 34px");

    }

    // Returns the button representing the piece chosen for the promotion
    public Button getPiece() {
        return piece;
    }
}
