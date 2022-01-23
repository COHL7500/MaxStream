package project_code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Arrays;

// Kontrollerer siden for en films detaljer (når man klipper på en knap, som tilhører en film)

public class showMovieController extends SceneController {

    @FXML
    private ImageView coverImageView;

    @FXML
    private Text movieTitle;

    @FXML
    private Text inputDate;

    @FXML
    private Text inputGenre;

    @FXML
    private Text inputRating;

    @FXML
    private Button addMyListButton;


    // Ved initialisering indlæses alle oplysninger for den gældende film/serie.

    @FXML
    public void initialize() throws IOException {

        Image image = ImageLoader.imageFinder(VideoDB.getMovieList().get(VideoDB.currentlyShownVideo));
        coverImageView.setImage(image);

        movieTitle.setText(VideoDB.getMovieList().get(VideoDB.currentlyShownVideo).getTitle());

        inputDate.setText(VideoDB.getMovieList().get(VideoDB.currentlyShownVideo).getReleaseYear().toString());

        inputGenre.setText(Arrays.toString(VideoDB.getMovieList().get(VideoDB.currentlyShownVideo).getGenres())
                .replace("[", "")
                .replace("]", ""));

        inputRating.setText(VideoDB.getMovieList().get(VideoDB.currentlyShownVideo).getRating().toString());
    }

    // Når du klikker på "add to list"-knappen, bliver filmen/serien gemt til ens liste.
    // Der er intet tilfælde af Input/Ouput her, så spild at nævne en IOException.
    @FXML
    public void addToMyList() throws IOException {

        ProfileDB.currProfile.addToMyList(VideoDB.getMovieList().get(VideoDB.currentlyShownVideo),
                VideoDB.currentlyShownVideo);
        addMyListButton.setTextFill(Color.GREEN);
    }



}
