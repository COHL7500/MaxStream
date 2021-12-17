package project_code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class mainMoviesController extends MainController {

    @FXML
    private TilePane mainTilePane;


    public void initialize() throws IOException, URISyntaxException {

        profileAvatar.setFill(ProfileDB.currProfile.getColor());

        System.out.println(VideoDB.getMovieList().size()); // testing

        for(int i = 0; i < VideoDB.getMovieList().size(); i++)
        {
            Button button = MainController.buildVideoButton(VideoDB.getMovieList().get(i));
            button.setId(Integer.toString(i));
            mainTilePane.getChildren().add(button);
        }
    }
}
