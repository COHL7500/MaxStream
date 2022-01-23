package project_code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class mainSeriesController extends MainController {

    // Siden for serier.

    // Denne variabel burde have været en del af SceneController eller videoDB, ville jeg mene.
    // Koden gentages og bruges i næsten alle controllerne.
    @FXML
    private Circle profileAvatar;

    @FXML
    private TilePane mainTilePane;

    @FXML
    private ComboBox genreFilter;


    @FXML
    public void initialize() throws IOException, URISyntaxException {
        profileAvatar.setFill(ProfileDB.currProfile.getColor());

        genreFilter.getItems().add("All");

        for (int i = 3; i < VideoDB.getGenreList().size(); i++) {
            genreFilter.getItems().add(VideoDB.getGenreList().get(i));
        }

        // Bygger alle knapperne for serierne.
        for (int i = 0; i < 100; i++) {

            // Der er absolut ingen årsag til at skrive "MainController".
            // Man kunne bare skrive " buildVideoButton..."
            // Dårlig praksis
            Button button = MainController.buildVideoButton(VideoDB.getSeriesList().get(i));
            button.setId(Integer.toString(i));
            mainTilePane.getChildren().add(button);

            genreIncludedMap.put(VideoDB.getMovieList().get(i), button);
        }
    }

    // Dette var bygget i absolut sidste minut.
    // Koden fungerer ikke korrekt, dog var det en mulig løsning.
    // IOException behøves ikke at blive kastet.

    public void onGenreChange() throws IOException {
        String currGenre = (String) genreFilter.getValue();

        for (Video key : genreIncludedMap.keySet()) {
            if (genreFilter.getValue() == "All") {

                for (Video exclKey : genreExcludedMap.keySet()) {
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