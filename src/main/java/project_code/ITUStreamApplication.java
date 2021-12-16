package project_code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class ITUStreamApplication extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(ITUStreamApplication.class.getResource("profile-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load()); // v = horizontal, v2 = vertical
            primaryStage.setTitle("ITUStream - Select Profile");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

            VideoDB.buildMovieList();
            VideoDB.buildSeriesList();
            VideoDB.buildVideoList();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void changeScene(String fxml) throws IOException
    {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}