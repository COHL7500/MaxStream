package project_code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Arrays;

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



}
