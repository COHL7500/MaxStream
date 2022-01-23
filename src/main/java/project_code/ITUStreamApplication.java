package project_code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


// Initialiseringen af applikationen: Sørger for programmet starter.
// Fun fact: Programmet har kun én enkel stage; primaryStage.
// Vi skifter mellem scener, således har vi kun brug for en stage.
// Stage = vinduet, Scene = indholdet/elementerne inde i vinduet.

public class ITUStreamApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
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
            VideoDB.buildGenreList();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}