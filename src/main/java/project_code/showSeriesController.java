package project_code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Arrays;

public class showSeriesController extends SceneController {

    @FXML
    private ImageView coverImageView;

    @FXML
    private Text seriesTitle;

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

        Image image = ImageLoader.imageFinder(VideoDB.getSeriesList().get(VideoDB.currentlyShownVideo % 100));

        coverImageView.setImage(image);

        seriesTitle.setText(VideoDB.getSeriesList().get(VideoDB.currentlyShownVideo % 100).getTitle());

        inputDate.setText(VideoDB.getSeriesList().get(VideoDB.currentlyShownVideo % 100).getReleaseYear().toString()
                + (VideoDB.getSeriesList().get(VideoDB.currentlyShownVideo % 100).getYearEnd() == 0 ? "-" :
                "-" + VideoDB.getSeriesList().get(VideoDB.currentlyShownVideo % 100).getYearEnd().toString()));

        inputGenre.setText(Arrays.toString(VideoDB.getSeriesList().get(VideoDB.currentlyShownVideo % 100).getGenres())
                .replace("[", "")
                .replace("]", ""));

        inputRating.setText(VideoDB.getSeriesList().get(VideoDB.currentlyShownVideo % 100).getRating().toString());
    }

    @FXML
    public void addToMyList() throws IOException {

        ProfileDB.currProfile.addToMyList(VideoDB.getSeriesList().get(VideoDB.currentlyShownVideo % 100),
                VideoDB.currentlyShownVideo % 100);

        addMyListButton.setTextFill(Color.GREEN);
    }


}
