package chess.gui;

import chess.game.board.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Controller {
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

    @FXML
    private BorderPane borderPaneChessBoard;
    @FXML
    private Label lblTurn;
    @FXML
    private MenuItem menuNewGame;
    @FXML
    private Label lblActionHistory;

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

    private Set<Button> fieldsSet = new HashSet<>();
    private Set<Label> removedPiecesSet = new HashSet<>();

    private Board board = new Board();
    private int firstBtnClicked = 0;
    private Button tempBtn1 = null;
    private Button tempBtn2 = null;

    public void initialize() {
        fieldsSet.add(btn11);
        fieldsSet.add(btn12);
        fieldsSet.add(btn13);
        fieldsSet.add(btn14);
        fieldsSet.add(btn15);
        fieldsSet.add(btn16);
        fieldsSet.add(btn17);
        fieldsSet.add(btn18);
        fieldsSet.add(btn21);
        fieldsSet.add(btn22);
        fieldsSet.add(btn23);
        fieldsSet.add(btn24);
        fieldsSet.add(btn25);
        fieldsSet.add(btn26);
        fieldsSet.add(btn27);
        fieldsSet.add(btn28);
        fieldsSet.add(btn31);
        fieldsSet.add(btn32);
        fieldsSet.add(btn33);
        fieldsSet.add(btn34);
        fieldsSet.add(btn35);
        fieldsSet.add(btn36);
        fieldsSet.add(btn37);
        fieldsSet.add(btn38);
        fieldsSet.add(btn41);
        fieldsSet.add(btn42);
        fieldsSet.add(btn43);
        fieldsSet.add(btn44);
        fieldsSet.add(btn45);
        fieldsSet.add(btn46);
        fieldsSet.add(btn47);
        fieldsSet.add(btn48);
        fieldsSet.add(btn51);
        fieldsSet.add(btn52);
        fieldsSet.add(btn53);
        fieldsSet.add(btn54);
        fieldsSet.add(btn55);
        fieldsSet.add(btn56);
        fieldsSet.add(btn57);
        fieldsSet.add(btn58);
        fieldsSet.add(btn61);
        fieldsSet.add(btn62);
        fieldsSet.add(btn63);
        fieldsSet.add(btn64);
        fieldsSet.add(btn65);
        fieldsSet.add(btn66);
        fieldsSet.add(btn67);
        fieldsSet.add(btn68);
        fieldsSet.add(btn71);
        fieldsSet.add(btn72);
        fieldsSet.add(btn73);
        fieldsSet.add(btn74);
        fieldsSet.add(btn75);
        fieldsSet.add(btn76);
        fieldsSet.add(btn77);
        fieldsSet.add(btn78);
        fieldsSet.add(btn81);
        fieldsSet.add(btn82);
        fieldsSet.add(btn83);
        fieldsSet.add(btn84);
        fieldsSet.add(btn85);
        fieldsSet.add(btn86);
        fieldsSet.add(btn87);
        fieldsSet.add(btn88);

        removedPiecesSet.add(removedWhitePawn1);
        removedPiecesSet.add(removedWhitePawn2);
        removedPiecesSet.add(removedWhitePawn3);
        removedPiecesSet.add(removedWhitePawn4);
        removedPiecesSet.add(removedWhitePawn5);
        removedPiecesSet.add(removedWhitePawn6);
        removedPiecesSet.add(removedWhitePawn7);
        removedPiecesSet.add(removedWhitePawn8);
        removedPiecesSet.add(removedBlackPawn1);
        removedPiecesSet.add(removedBlackPawn2);
        removedPiecesSet.add(removedBlackPawn3);
        removedPiecesSet.add(removedBlackPawn4);
        removedPiecesSet.add(removedBlackPawn5);
        removedPiecesSet.add(removedBlackPawn6);
        removedPiecesSet.add(removedBlackPawn7);
        removedPiecesSet.add(removedBlackPawn8);
        removedPiecesSet.add(removedWhiteRook1);
        removedPiecesSet.add(removedWhiteRook2);
        removedPiecesSet.add(removedWhiteKnight1);
        removedPiecesSet.add(removedWhiteKnight2);
        removedPiecesSet.add(removedWhiteBishop1);
        removedPiecesSet.add(removedWhiteBishop2);
        removedPiecesSet.add(removedWhiteQueen);
        removedPiecesSet.add(removedBlackRook1);
        removedPiecesSet.add(removedBlackRook2);
        removedPiecesSet.add(removedBlackKnight1);
        removedPiecesSet.add(removedBlackKnight2);
        removedPiecesSet.add(removedBlackBishop1);
        removedPiecesSet.add(removedBlackBishop2);
        removedPiecesSet.add(removedBlackQueen);
    }

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

    private void updateRemovedWhitePawn() {
        if (removedWhitePawn1.getText().isBlank()) {
            removedWhitePawn1.setText("♙");
        } else if (removedWhitePawn2.getText().isBlank()) {
            removedWhitePawn2.setText("♙");
        } else if (removedWhitePawn3.getText().isBlank()) {
            removedWhitePawn3.setText("♙");
        } else if (removedWhitePawn4.getText().isBlank()) {
            removedWhitePawn4.setText("♙");
        } else if (removedWhitePawn5.getText().isBlank()) {
            removedWhitePawn5.setText("♙");
        } else if (removedWhitePawn6.getText().isBlank()) {
            removedWhitePawn6.setText("♙");
        } else if (removedWhitePawn7.getText().isBlank()) {
            removedWhitePawn7.setText("♙");
        } else {
            removedWhitePawn8.setText("♙");
        }
    }

    private void updateRemovedBlackPawn() {
        if (removedBlackPawn1.getText().isBlank()) {
            removedBlackPawn1.setText("♟");
        } else if (removedBlackPawn2.getText().isBlank()) {
            removedBlackPawn2.setText("♟");
        } else if (removedBlackPawn3.getText().isBlank()) {
            removedBlackPawn3.setText("♟");
        } else if (removedBlackPawn4.getText().isBlank()) {
            removedBlackPawn4.setText("♟");
        } else if (removedBlackPawn5.getText().isBlank()) {
            removedBlackPawn5.setText("♟");
        } else if (removedBlackPawn6.getText().isBlank()) {
            removedBlackPawn6.setText("♟");
        } else if (removedBlackPawn7.getText().isBlank()) {
            removedBlackPawn7.setText("♟");
        } else {
            removedBlackPawn8.setText("♟");
        }
    }

    private void updateRemovedPieces(String removedPiece) {
        switch (removedPiece) {
            case "♙":
                updateRemovedWhitePawn();
                break;
            case "♖":
                if (removedWhiteRook1.getText().isBlank()) {
                    removedWhiteRook1.setText("♖");
                } else if (removedWhiteRook2.getText().isBlank()) {
                    removedBlackRook2.setText("♖");
                } else {
                    updateRemovedWhitePawn();
                }
                break;
            case "♘":
                if (removedWhiteKnight1.getText().isBlank()) {
                    removedWhiteKnight1.setText("♘");
                } else if (removedWhiteKnight2.getText().isBlank()) {
                    removedBlackKnight2.setText("♘");
                } else {
                    updateRemovedWhitePawn();
                }
                break;
            case "♗":
                if (removedWhiteBishop1.getText().isBlank()) {
                    removedWhiteBishop1.setText("♗");
                } else if (removedWhiteBishop2.getText().isBlank()) {
                    removedBlackBishop2.setText("♗");
                } else {
                    updateRemovedWhitePawn();
                }
                break;
            case "♕":
                if (removedWhiteQueen.getText().isBlank()) {
                    removedWhiteQueen.setText("♕");
                } else {
                    updateRemovedWhitePawn();
                }
                break;
            case "♟":
                updateRemovedBlackPawn();
                break;
            case "♜":
                if (removedBlackRook1.getText().isBlank()) {
                    removedBlackRook1.setText("♜");
                } else if (removedBlackRook2.getText().isBlank()) {
                    removedBlackRook2.setText("♜");
                } else {
                    updateRemovedBlackPawn();
                }
                break;
            case "♞":
                if (removedBlackKnight1.getText().isBlank()) {
                    removedBlackKnight1.setText("♞");
                } else if (removedBlackKnight2.getText().isBlank()) {
                    removedBlackKnight2.setText("♞");
                } else {
                    updateRemovedBlackPawn();
                }
                break;
            case "♝":
                if (removedBlackBishop1.getText().isBlank()) {
                    removedBlackBishop1.setText("♝");
                } else if (removedBlackBishop2.getText().isBlank()) {
                    removedBlackBishop2.setText("♝");
                } else {
                    updateRemovedBlackPawn();
                }
                break;
            case "♛":
                if (removedBlackQueen.getText().isBlank()) {
                    removedBlackQueen.setText("♛");
                } else {
                    updateRemovedBlackPawn();
                }
                break;
            default:
                break;
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
