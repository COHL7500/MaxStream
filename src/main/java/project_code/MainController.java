package project_code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainController {

    Stage stage;

    Scene scene;

    @FXML
    public Circle profileAvatar;

    @FXML
    public TilePane mainTilePane;

    @FXML
    protected static Button buildVideoButton(Video video) throws IOException
    {

        FXMLLoader buttonLoader = new FXMLLoader(ITUStreamApplication.class.getResource("videobutton.fxml"));
        Button button = buttonLoader.load();

        Image image = ImageLoader.imageFinder(video);
        ImageView imageView = (ImageView) button.getGraphic();
        imageView.setImage(image);

        return button;
    }

    @FXML
    public void initialize() throws IOException, URISyntaxException {
        profileAvatar.setFill(ProfileDB.currProfile.getColor());

        System.out.println(VideoDB.getMovieList().size());

        for(int i = 0; i < VideoDB.getMovieList().size(); i++)
        {
            mainTilePane.getChildren().add(buildVideoButton(VideoDB.getVideoList().get(i)));
        }
    }

    @FXML
    public void switchProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToMovieScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainMovies-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToSeriesScene(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("mainSeries-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToMyListScene(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("myList-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    //TODO:
    // Grouping the pictures
    // Buttons for "film, serier, min liste"
    // functionality for filtering movies
    // showing all the movies
}
