package project_code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class mainMoviesController extends MainController {

    @FXML
    private TilePane mainTilePane;

    @FXML
    private ComboBox genreFilter;


    public void initialize() throws IOException, URISyntaxException {

        genreFilter.getItems().add("All");

        for (int i = 0; i < 19; i++) {
            genreFilter.getItems().add(VideoDB.getGenreList().get(i));
        }

        profileAvatar.setFill(ProfileDB.currProfile.getColor());

        System.out.println(VideoDB.getMovieList().size()); // testing

        for (int i = 0; i < VideoDB.getMovieList().size(); i++) {
            Button button = MainController.buildVideoButton(VideoDB.getMovieList().get(i));
            button.setId(Integer.toString(i));
            mainTilePane.getChildren().add(button);
            genreIncludedMap.put(VideoDB.getMovieList().get(i), button);
        }
    }

    public void onGenreChange() throws IOException {
        String currGenre = (String) genreFilter.getValue();

        for (Video key : genreIncludedMap.keySet()) {
            if (genreFilter.getValue() == "All") {

                for(Video exclKey : genreExcludedMap.keySet()) {
                    mainTilePane.getChildren().add(genreExcludedMap.get(exclKey));
                }

                genreExcludedMap.clear();
            }

            if (!Arrays.asList(key.getGenres()).contains(currGenre)) {
                mainTilePane.getChildren().remove(genreIncludedMap.get(key));
                genreExcludedMap.put(key, genreIncludedMap.get(key));
            }

          


   
   
   
   



        }
    }
}
