package project_code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URISyntaxException;

public class mainSeriesController extends mainMoviesController {

    @FXML
    private Circle profileAvatar;

    @FXML
    private TilePane mainTilePane;

    @FXML
    public void initialize() throws IOException, URISyntaxException {
        profileAvatar.setFill(ProfileDB.currProfile.getColor());

        for(int i = 0; i < 100; i++)
        {
            Button button = MainController.buildVideoButton(VideoDB.getSeriesList().get(i));
            button.setId(Integer.toString(i));
            mainTilePane.getChildren().add(button);
        }
    }
}
