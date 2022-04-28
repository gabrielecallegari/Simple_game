module com.example.sample_game {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.sample_game to javafx.fxml;
    exports com.example.sample_game;
}