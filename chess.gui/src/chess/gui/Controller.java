package chess.gui;

import chess.game.board.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.*;

public class Controller {

    //Declaration of the buttons that function as fields on the chess board
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private Button btn13;
    @FXML
    private Button btn14;
    @FXML
    private Button btn15;
    @FXML
    private Button btn16;
    @FXML
    private Button btn17;
    @FXML
    private Button btn18;
    @FXML
    private Button btn21;
    @FXML
    private Button btn22;
    @FXML
    private Button btn23;
    @FXML
    private Button btn24;
    @FXML
    private Button btn25;
    @FXML
    private Button btn26;
    @FXML
    private Button btn27;
    @FXML
    private Button btn28;
    @FXML
    private Button btn31;
    @FXML
    private Button btn32;
    @FXML
    private Button btn33;
    @FXML
    private Button btn34;
    @FXML
    private Button btn35;
    @FXML
    private Button btn36;
    @FXML
    private Button btn37;
    @FXML
    private Button btn38;
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
    private Button btn61;
    @FXML
    private Button btn62;
    @FXML
    private Button btn63;
    @FXML
    private Button btn64;
    @FXML
    private Button btn65;
    @FXML
    private Button btn66;
    @FXML
    private Button btn67;
    @FXML
    private Button btn68;
    @FXML
    private Button btn71;
    @FXML
    private Button btn72;
    @FXML
    private Button btn73;
    @FXML
    private Button btn74;
    @FXML
    private Button btn75;
    @FXML
    private Button btn76;
    @FXML
    private Button btn77;
    @FXML
    private Button btn78;
    @FXML
    private Button btn81;
    @FXML
    private Button btn82;
    @FXML
    private Button btn83;
    @FXML
    private Button btn84;
    @FXML
    private Button btn85;
    @FXML
    private Button btn86;
    @FXML
    private Button btn87;
    @FXML
    private Button btn88;

    // Declaration of the labels that will show the chess pieces next to the board, after the have been captured
    @FXML
    private Label removedWhiteRook1;
    @FXML
    private Label removedWhiteRook2;
    @FXML
    private Label removedWhiteKnight1;
    @FXML
    private Label removedWhiteKnight2;
    @FXML
    private Label removedWhiteBishop1;
    @FXML
    private Label removedWhiteBishop2;
    @FXML
    private Label removedWhiteQueen;
    @FXML
    private Label removedWhitePawn1;
    @FXML
    private Label removedWhitePawn2;
    @FXML
    private Label removedWhitePawn3;
    @FXML
    private Label removedWhitePawn4;
    @FXML
    private Label removedWhitePawn5;
    @FXML
    private Label removedWhitePawn6;
    @FXML
    private Label removedWhitePawn7;
    @FXML
    private Label removedWhitePawn8;
    @FXML
    private Label removedBlackRook1;
    @FXML
    private Label removedBlackRook2;
    @FXML
    private Label removedBlackKnight1;
    @FXML
    private Label removedBlackKnight2;
    @FXML
    private Label removedBlackBishop1;
    @FXML
    private Label removedBlackBishop2;
    @FXML
    private Label removedBlackQueen;
    @FXML
    private Label removedBlackPawn1;
    @FXML
    private Label removedBlackPawn2;
    @FXML
    private Label removedBlackPawn3;
    @FXML
    private Label removedBlackPawn4;
    @FXML
    private Label removedBlackPawn5;
    @FXML
    private Label removedBlackPawn6;
    @FXML
    private Label removedBlackPawn7;
    @FXML
    private Label removedBlackPawn8;

    @FXML
    private BorderPane borderPaneChessBoard;
    @FXML
    private Label lblTurn;
    @FXML
    private MenuItem menuNewGame;
    @FXML
    private Label lblActionHistory;

    private final Set<Button> darkFieldsSet = new HashSet<>();
    private final Set<Button> lightFieldsSet = new HashSet<>();
    private final Set<Button> fieldsSet = new HashSet<>();
    private final Set<Label> removedPiecesSet = new LinkedHashSet<>();

    private Board board = new Board();
    private int firstBtnClicked = 0;
    private Button tempBtn1 = null;
    private Button tempBtn2 = null;
    private String theme = "gray";
    private List<Label> removedPiecesHistory = new LinkedList<>();

    // Adds all buttons that represent the fields and the labels for the removed pieces to their collections
    public void initialize() {
        initializeDarkFieldsSet();
        initializeLightFieldsSet();
        fieldsSet.addAll(darkFieldsSet);
        fieldsSet.addAll(lightFieldsSet);
        initializeRemovedPiecesSet();
    }

    // Adds the white/light colored buttons representing the white/light fields to their collection
    private void initializeLightFieldsSet() {
        lightFieldsSet.add(btn12);
        lightFieldsSet.add(btn14);
        lightFieldsSet.add(btn16);
        lightFieldsSet.add(btn18);
        lightFieldsSet.add(btn21);
        lightFieldsSet.add(btn23);
        lightFieldsSet.add(btn25);
        lightFieldsSet.add(btn27);
        lightFieldsSet.add(btn32);
        lightFieldsSet.add(btn34);
        lightFieldsSet.add(btn36);
        lightFieldsSet.add(btn38);
        lightFieldsSet.add(btn41);
        lightFieldsSet.add(btn43);
        lightFieldsSet.add(btn45);
        lightFieldsSet.add(btn47);
        lightFieldsSet.add(btn52);
        lightFieldsSet.add(btn54);
        lightFieldsSet.add(btn56);
        lightFieldsSet.add(btn58);
        lightFieldsSet.add(btn61);
        lightFieldsSet.add(btn63);
        lightFieldsSet.add(btn65);
        lightFieldsSet.add(btn67);
        lightFieldsSet.add(btn72);
        lightFieldsSet.add(btn74);
        lightFieldsSet.add(btn76);
        lightFieldsSet.add(btn78);
        lightFieldsSet.add(btn81);
        lightFieldsSet.add(btn83);
        lightFieldsSet.add(btn85);
        lightFieldsSet.add(btn87);
    }

    // Adds the dark/black buttons representing the dark/black fields to their collection
    private void initializeDarkFieldsSet() {
        darkFieldsSet.add(btn11);
        darkFieldsSet.add(btn13);
        darkFieldsSet.add(btn15);
        darkFieldsSet.add(btn17);
        darkFieldsSet.add(btn22);
        darkFieldsSet.add(btn24);
        darkFieldsSet.add(btn26);
        darkFieldsSet.add(btn28);
        darkFieldsSet.add(btn31);
        darkFieldsSet.add(btn33);
        darkFieldsSet.add(btn35);
        darkFieldsSet.add(btn37);
        darkFieldsSet.add(btn42);
        darkFieldsSet.add(btn44);
        darkFieldsSet.add(btn46);
        darkFieldsSet.add(btn48);
        darkFieldsSet.add(btn51);
        darkFieldsSet.add(btn53);
        darkFieldsSet.add(btn55);
        darkFieldsSet.add(btn57);
        darkFieldsSet.add(btn62);
        darkFieldsSet.add(btn64);
        darkFieldsSet.add(btn66);
        darkFieldsSet.add(btn68);
        darkFieldsSet.add(btn71);
        darkFieldsSet.add(btn73);
        darkFieldsSet.add(btn75);
        darkFieldsSet.add(btn77);
        darkFieldsSet.add(btn82);
        darkFieldsSet.add(btn84);
        darkFieldsSet.add(btn86);
        darkFieldsSet.add(btn88);
    }

    // Adds the labels representing the captured pieces to their collection
    private void initializeRemovedPiecesSet() {
        removedPiecesSet.add(removedWhitePawn1);
        removedPiecesSet.add(removedWhitePawn2);
        removedPiecesSet.add(removedWhitePawn3);
        removedPiecesSet.add(removedWhitePawn4);
        removedPiecesSet.add(removedWhitePawn5);
        removedPiecesSet.add(removedWhitePawn6);
        removedPiecesSet.add(removedWhitePawn7);
        removedPiecesSet.add(removedWhitePawn8);
        removedPiecesSet.add(removedWhiteRook1);
        removedPiecesSet.add(removedWhiteRook2);
        removedPiecesSet.add(removedWhiteKnight1);
        removedPiecesSet.add(removedWhiteKnight2);
        removedPiecesSet.add(removedWhiteBishop1);
        removedPiecesSet.add(removedWhiteBishop2);
        removedPiecesSet.add(removedWhiteQueen);
        removedPiecesSet.add(removedBlackPawn1);
        removedPiecesSet.add(removedBlackPawn2);
        removedPiecesSet.add(removedBlackPawn3);
        removedPiecesSet.add(removedBlackPawn4);
        removedPiecesSet.add(removedBlackPawn5);
        removedPiecesSet.add(removedBlackPawn6);
        removedPiecesSet.add(removedBlackPawn7);
        removedPiecesSet.add(removedBlackPawn8);
        removedPiecesSet.add(removedBlackRook1);
        removedPiecesSet.add(removedBlackRook2);
        removedPiecesSet.add(removedBlackKnight1);
        removedPiecesSet.add(removedBlackKnight2);
        removedPiecesSet.add(removedBlackBishop1);
        removedPiecesSet.add(removedBlackBishop2);
        removedPiecesSet.add(removedBlackQueen);
    }

    // Assigns the first or second button/field clicked to the correct member variable reference and
    // starts the action method.
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

    // Pop-up window created when a players king is check and the player tries to move a piece that does not solve this situation.
    private void checkWarning() {
        if (lblTurn.getText().contains("Check!")) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.getButtonTypes().add(ButtonType.OK);
            alert.setTitle("Check");
            alert.setContentText("It is check, you should solve this situation or your king will die!");
            alert.showAndWait();
        }
    }

    // Calls all the methods verifying the legality of the move and verifying if there is a case of check, checkmate or stalemate.
    private void action(int button) {
        if (firstBtnClicked != 0) {
            int tempBtn2Location = Integer.parseInt(tempBtn2.getId().substring(3,5));
            int tempBtn1Location = Integer.parseInt(tempBtn1.getId().substring(3,5));
            String tempBtn2ID = tempBtn2.getId();
            if (board.movePiece(firstBtnClicked, button)) {
                if (tempBtn2.getText().length() > 0) {
                    updateRemovedPieces(tempBtn2.getText());
                }
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
        lblActionHistory.setText(board.getActionHistory());
    }

    // Puts the captured piece next to the board
    private void updateRemovedPieces(String capturedPiece) {
        Label lblRemovedPiece = null;
        try {
            lblRemovedPiece = searchRemovedPiece(capturedPiece, false);
        } catch (ItemNotFoundException exception1) {
            try {
                if (board.getWhitesTurn()) {
                    lblRemovedPiece = searchRemovedPiece("♟", false);
                } else {
                    lblRemovedPiece = searchRemovedPiece("♙", false);
                }
            } catch (ItemNotFoundException exception2) {
                System.out.println(exception2.getMessage());
            }
        } finally {
            lblRemovedPiece.setVisible(true);
            removedPiecesHistory.add(lblRemovedPiece);
        }
    }

    // When a pawn reaches the final row, a pup-up window appears, asking which replacement piece is desired for the promotion.
    private String promotion(int destination) {
        String newPiece = "";
        if ((tempBtn1.getText().equals("♙") && destination / 10 == 8) ||
                (tempBtn1.getText().equals("♟") && destination / 10 == 1)){
            Dialog<ButtonType> choosePromotion = new Dialog<>();
            choosePromotion.initOwner(borderPaneChessBoard.getScene().getWindow());
            choosePromotion.setTitle("Promotion");
            FXMLLoader fxmlLoader = new FXMLLoader();
            if (board.getWhitesTurn()) {
                fxmlLoader.setLocation(getClass().getResource("promotionBlack.fxml"));
            } else {
                fxmlLoader.setLocation(getClass().getResource("promotionWhite.fxml"));
            }
            try {
                choosePromotion.getDialogPane().setContent(fxmlLoader.load());
            } catch (IOException e) {
                System.out.println("Couldn't open choosePromotion: " + e.getMessage());
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

    // In case of castling and 'en passant' not only are the two buttons/fields that where clicked involved in a change,
    // but also one or two other fields.
    public void specialMove(int pos1, int pos2, String btn2Id) {
        // Removes the captured pawn from the game, in case of 'en passant', this removal is only for the UI, the removal of the
        // piece in the game itself (backend) is performed in the chess.game module and package.
        if ((pos2 % 10 == pos1 % 10 + 1 || pos2 % 10 == pos1 % 10 - 1) &&
                (tempBtn2.getText().equals(""))) {
            // White pawn passing and capturing a black pawn
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
                updateRemovedPieces("♟");
            // Black pawn passing and capturing a white pawn
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
                updateRemovedPieces("♙");
            }
        // Places the rook in the correct position when the king is moved for castling,
        // this repositioning is only for the UI, the repositioning of the rook in the game itself (backend)
        // is performed in the chess.game module and package.
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

    // Starts a new game
    @FXML
    public void onClickNewGame(ActionEvent newGameClicked) {

    }

    // Undo the last move
    @FXML
    public void onClickUndo() throws Exception {
        String removedPiece = board.getLastCapturedPiece();
        int[] positions = board.undo();
        if (positions.length == 0) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.getButtonTypes().add(ButtonType.OK);
            alert.setTitle("First move");
            alert.setContentText("Action history is empty, cannot undo last move!");
            alert.showAndWait();
            return;
        }
        tempBtn2 = searchButton(positions[0]);
        tempBtn1 = searchButton(positions[1]);
        tempBtn2.setText(tempBtn1.getText());
        tempBtn1.setText("");
        if (positions[2] == 1) {
            if (board.getWhitesTurn()) {
                tempBtn2.setText("♙");
            } else {
                tempBtn2.setText("♟");
            }
        }
        if (positions.length == 4) {
            Label lblRemovedPiece = removedPiecesHistory.get(removedPiecesHistory.size()-1);
            lblRemovedPiece.setVisible(false);
            removedPiecesHistory.remove(lblRemovedPiece);
            searchButton(positions[3]).setText(removedPiece);

        } else if (positions.length == 5) {
            if (board.getWhitesTurn()) {
                searchButton(positions[3]).setText("♖");
            } else {
                searchButton(positions[3]).setText("♜");
            }
            searchButton(positions[4]).setText("");
        }
        if (board.getWhitesTurn()) {
            lblTurn.setText("It is white's turn");
        } else {
            lblTurn.setText("It is black's turn");
        }
        if (board.check(board.getWhitesTurn()).length() > 0) {
            lblTurn.setText("Check! " + lblTurn.getText());
        }
        lblActionHistory.setText(board.getActionHistory());
        firstBtnClicked = 0;
        tempBtn1 = null;
        tempBtn2 = null;
    }

    private class ItemNotFoundException extends Exception {
        private ItemNotFoundException (String message) {
            super(message);
        }
    }

    private Button searchButton(int buttonLocation) throws ItemNotFoundException {
        for (Button button : fieldsSet) {
            int buttonPosition = Integer.parseInt(button.getId().substring(3));
            if (buttonPosition == buttonLocation) {
                return button;
            }
        }

        throw new ItemNotFoundException("Button not present in FieldsSet");
    }

    private Label searchRemovedPiece(String capturedPiece, boolean visible) throws ItemNotFoundException {
        for (Label lblRemovedPiece : removedPiecesSet) {
            if (lblRemovedPiece.getText().equals(capturedPiece) && lblRemovedPiece.isVisible() == visible) {
                return lblRemovedPiece;
            }
        }
        throw new ItemNotFoundException("Label not present in removedPiecesSet");
    }

    // Changes the color theme to the default gray theme
    @FXML
    public void onClickGray() {
        for (Button button : darkFieldsSet) {
            button.setStyle("-fx-background-color: #666666; -fx-font-size: 34px");
        }
        for (Button button : lightFieldsSet) {
            button.setStyle("-fx-background-color: #cccccc; -fx-font-size: 34px");
        }
        theme = "gray";
    }

    // Changes the color theme to the green theme
    @FXML
    public void onClickGreen() {
        for (Button button : darkFieldsSet) {
            button.setStyle("-fx-background-color: #455843; -fx-font-size: 34px");
        }
        for (Button button : lightFieldsSet) {
            button.setStyle("-fx-background-color: #dddddd; -fx-font-size: 34px");
        }
        theme = "green";
    }

    // Changes the color theme to the blue theme
    @FXML
    public void onClickBlue() {
        for (Button button : darkFieldsSet) {
            button.setStyle("-fx-background-color: #0a162c; -fx-font-size: 34px");
        }
        for (Button button : lightFieldsSet) {
            button.setStyle("-fx-background-color: #cdcdcd; -fx-font-size: 34px");
        }
        theme = "blue";
    }

    // After a second button/field is clicked the color of the first button/field must be reset to its initial color
    // depending on the active color theme.
    public void resetFieldColors() {
        if (darkFieldsSet.contains(tempBtn1)) {
            switch (theme) {
                case "gray":
                default:
                    tempBtn1.setStyle("-fx-background-color: #666666; -fx-font-size: 34px");
                    break;
                case "green":
                    tempBtn1.setStyle("-fx-background-color: #455843; -fx-font-size: 34px");
                    break;
                case "blue":
                    tempBtn1.setStyle("-fx-background-color: #0a162c; -fx-font-size: 34px");
                    break;
            }
        } else {
            switch (theme) {
                case "gray":
                default:
                    tempBtn1.setStyle("-fx-background-color: #cccccc; -fx-font-size: 34px");
                    break;
                case "green":
                    tempBtn1.setStyle("-fx-background-color: #dddddd; -fx-font-size: 34px");
                    break;
                case "blue":
                    tempBtn1.setStyle("-fx-background-color: #cdcdcd; -fx-font-size: 34px");
                    break;
            }
        }
        tempBtn1 = null;
        firstBtnClicked = 0;
    }
}
