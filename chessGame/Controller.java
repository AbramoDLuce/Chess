package chessGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class Controller {
    @FXML
    private Button btn14;
    @FXML
    private Button btn11;
    @FXML
    private Button btn16;
    @FXML
    private Button btn18;

    @FXML
    private Button btn41;
    @FXML
    private Button btn42;
    @FXML
    private Button btn43;
    @FXML
    private Button btn44;
    @FXML
    private Button btn45;
    @FXML
    private Button btn46;
    @FXML
    private Button btn47;
    @FXML
    private Button btn48;

    @FXML
    private Button btn51;
    @FXML
    private Button btn52;
    @FXML
    private Button btn53;
    @FXML
    private Button btn54;
    @FXML
    private Button btn55;
    @FXML
    private Button btn56;
    @FXML
    private Button btn57;
    @FXML
    private Button btn58;

    @FXML
    private Button btn84;
    @FXML
    private Button btn81;
    @FXML
    private Button btn86;
    @FXML
    private Button btn88;

    @FXML
    private BorderPane borderPaneChessBoard;
    @FXML
    private Label lblTurn;
    @FXML
    private MenuItem menuNewGame;


    private Board board = new Board();
    private int firstBtnClicked = 0;
    private Button tempBtn1 = null;
    private Button tempBtn2 = null;

    @FXML
    public void fieldClicked(ActionEvent event) {
        if (tempBtn1 == null) {
            tempBtn1 = (Button) event.getSource();
        } else {
            tempBtn2 = (Button) event.getSource();
        }
        char[] btnID = ((Button) event.getSource()).getId().toCharArray();
        int buttonNumber = Integer.parseInt(btnID[3] +""+ btnID[4]);
        action(buttonNumber);
    }

    @FXML
    public void btnGiveUpClicked() {

    }

    private void checkWarning() {
        if (lblTurn.getText().contains("Check!")) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.getButtonTypes().add(ButtonType.OK);
            alert.setTitle("Check");
            alert.setContentText("It is check, you should solve this situation or your king will die!");
            alert.showAndWait();
        }
    }

    private void showActionHistory() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getButtonTypes().add(ButtonType.OK);
        alert.setTitle("Action history");
        alert.setHeaderText("Moves made during this game");
        alert.setContentText(board.getActionHistory());
        alert.showAndWait();
    }

    private void action(int button) {
        if (firstBtnClicked != 0) {
            int tempBtn2Location = Integer.parseInt(tempBtn2.getId().substring(3,5));
            int tempBtn1Location = Integer.parseInt(tempBtn1.getId().substring(3,5));
            String tempBtn2ID = tempBtn2.getId();
            if (board.movePiece(firstBtnClicked, button)) {
                specialMove(tempBtn1Location, tempBtn2Location, tempBtn2ID);
                tempBtn2.setText(tempBtn1.getText());
                String newPiece = promotion(tempBtn2Location);
                board.promote(tempBtn2Location / 10, tempBtn2Location % 10, newPiece);
                tempBtn1.setText("");
                if (board.getWhitesTurn()) {
                    lblTurn.setText("It is white's turn");
                } else {
                    lblTurn.setText("It is black's turn");
                }
                if (board.check(board.getWhitesTurn()).length() > 0) {
                    if (board.checkMate(board.getWhitesTurn())) {
                        if (board.getWhitesTurn()) {
                            lblTurn.setText("Checkmate! Black wins!");
                        } else {
                            lblTurn.setText("Checkmate! White wins!");
                        }
                        showActionHistory();
                    }
                    if (!lblTurn.getText().contains("Checkmate")) {
                        lblTurn.setText("Check! " + lblTurn.getText());
                    }
                }
                if (board.stalemate(board.getWhitesTurn())) {
                    System.out.println("Stalemate, it is a draw");
                }
            } else {
                checkWarning();
            }
            resetFieldColors();
        } else {
            firstBtnClicked = button;
            tempBtn1.setStyle("-fx-background-color: #999999; -fx-font-size: 34px");
        }
    }

    private String promotion(int destination) {
        String newPiece = "";
        if ((tempBtn1.getText().equals("♙") && destination / 10 == 8) ||
                (tempBtn1.getText().equals("♟") && destination / 10 == 1)){
            Dialog<ButtonType> choosePromotion = new Dialog<>();
            choosePromotion.initOwner(borderPaneChessBoard.getScene().getWindow());
            choosePromotion.setTitle("Promotion");
            FXMLLoader fxmlLoader = new FXMLLoader();
            if (board.getWhitesTurn()) {
                fxmlLoader.setLocation(getClass().getResource("PromotionBlack.fxml"));
            } else {
                fxmlLoader.setLocation(getClass().getResource("promotionWhite.fxml"));
            }
            try {
                choosePromotion.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                System.out.println("Couldn't open choosePromotion " + e.getMessage());
            }

            choosePromotion.getDialogPane().getButtonTypes().add(ButtonType.OK);

            Optional<ButtonType> result = choosePromotion.showAndWait();
            if (result.isPresent()) {
                PromotionController controller = fxmlLoader.getController();
                newPiece = controller.getPiece().getText();
                tempBtn2.setText(newPiece);
            }
        }
        return newPiece;
    }

    // To change more than two fields in case of castling and en passant
    public void specialMove(int pos1, int pos2, String btn2Id) {
        // En passant
        if ((pos2 % 10 == pos1 % 10 + 1 || pos2 % 10 == pos1 % 10 - 1) &&
                (tempBtn2.getText().equals(""))) {
            // White en passant
            if (pos2 / 10 == pos1 / 10 + 1  && tempBtn1.getText().equals("♙")) {
                switch (btn2Id) {
                    case "btn61":
                        btn51.setText("");
                        break;
                    case "btn62":
                        btn52.setText("");
                        break;
                    case "btn63":
                        btn53.setText("");
                        break;
                    case "btn64":
                        btn54.setText("");
                        break;
                    case "btn65":
                        btn55.setText("");
                        break;
                    case "btn66":
                        btn56.setText("");
                        break;
                    case "btn67":
                        btn57.setText("");
                        break;
                    case "btn68":
                        btn58.setText("");
                        break;
                }
                // Black en passant
            } else if (pos2 / 10 == pos1 / 10 - 1  && tempBtn1.getText().equals("♟")) {
                switch (btn2Id) {
                    case "btn31":
                        btn41.setText("");
                        break;
                    case "btn32":
                        btn42.setText("");
                        break;
                    case "btn33":
                        btn43.setText("");
                        break;
                    case "btn34":
                        btn44.setText("");
                        break;
                    case "btn35":
                        btn45.setText("");
                        break;
                    case "btn36":
                        btn46.setText("");
                        break;
                    case "btn37":
                        btn47.setText("");
                        break;
                    case "btn38":
                        btn48.setText("");
                        break;
                }
            }
            // Castling
        } else if ((pos2 % 10 == pos1 % 10 + 2 || pos2 % 10 == pos1 % 10 - 2) &&
                (tempBtn1.getText().equals("♔") || tempBtn1.getText().equals("♚"))) {
            switch (btn2Id) {
                case "btn13":
                    btn14.setText(btn11.getText());
                    btn11.setText("");
                    break;
                case "btn17":
                    btn16.setText(btn18.getText());
                    btn18.setText("");
                    break;
                case "btn83":
                    btn84.setText(btn81.getText());
                    btn81.setText("");
                    break;
                case "btn87":
                    btn86.setText(btn88.getText());
                    btn88.setText("");
                    break;
            }
        }
    }

    @FXML
    public void onClickNewGame(ActionEvent newGameClicked) {

    }

    @FXML
    public void onClickUndo() {
    }

    @FXML
    public void onClickColors() {
    }

    @FXML
    public void onClickTheme() {
    }

    public void resetFieldColors() {
        if (((firstBtnClicked / 10) % 2 == 0 && firstBtnClicked % 2 == 0) || ((firstBtnClicked / 10) % 2 != 0 && firstBtnClicked % 2 != 0)) {
            tempBtn1.setStyle("-fx-background-color: #666666; -fx-font-size: 34px");
        } else {
            tempBtn1.setStyle("-fx-background-color: #cccccc; -fx-font-size: 34px");
        }
        tempBtn1 = null;
        firstBtnClicked = 0;
    }
}
