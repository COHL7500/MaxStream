package project_code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class mainMoviesController extends MainController {

    @FXML
    private Circle profileAvatar;

    @FXML
    private TilePane mainTilePane;


    public void initialize() throws IOException, URISyntaxException {
        profileAvatar.setFill(ProfileDB.currProfile.getColor());

        System.out.println(VideoDB.getMovieList().size()); // testing

        for(int i = 0; i < VideoDB.getMovieList().size(); i++)
        {
            mainTilePane.getChildren().add(MainController.buildVideoButton(VideoDB.getMovieList().get(i)));
        }
    }

    @FXML
    public void switchToMainScene(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
