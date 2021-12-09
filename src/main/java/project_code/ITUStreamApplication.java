package project_code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ITUStreamApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ITUStreamApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load()); // v = horizontal, v2 = vertical
        stage.setTitle("ITUStream - Front page");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}