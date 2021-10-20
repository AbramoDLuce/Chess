module chess.game.gui {
    requires javafx.fxml;
    requires javafx.controls;
    requires chess.game;

    exports chess.gui to javafx.fxml, javafx.graphics;
    opens chess.gui to javafx.fxml;
}