package project_code;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import java.util.Objects;

public class MainController extends SceneController {

    static Stage stage;

    static Scene scene;

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

        button.setOnAction(event -> {
            Parent root = null;

            VideoDB.currentlyShownVideo = Integer.parseInt(button.getId());
            System.out.println(VideoDB.currentlyShownVideo);

            try {
                root = FXMLLoader.load(Objects.requireNonNull(ITUStreamApplication.class.getResource(
                        video.getVideoType() instanceof Series ? "showSeries.fxml" : "showMovie.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            assert root != null;
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });


        return button;
    }

    @FXML
    public void initialize() throws IOException, URISyntaxException {
        profileAvatar.setFill(ProfileDB.currProfile.getColor());

        for(int i = 0; i < VideoDB.getVideoList().size(); i++)
        {
            Button button = buildVideoButton(VideoDB.getVideoList().get(i));
            button.setId(Integer.toString(i));
            mainTilePane.getChildren().add(button);
        }
    }





    //TODO:
    // Grouping the pictures
    // Buttons for "film, serier, min liste"
    // functionality for filtering movies
    // showing all the movies
}
