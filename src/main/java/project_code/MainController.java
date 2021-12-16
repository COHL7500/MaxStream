package project_code;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.io.IOException;

public class MainController {

    @FXML
    private Circle profileAvatar;

    @FXML
    public void displayVideo()
    {
        ;
    }

    @FXML
    private Button createVideoButton(Video video) throws IOException
    {
        FXMLLoader buttonLoader = new FXMLLoader(getClass().getResource("videobutton.fxml"));
        Button button = buttonLoader.load();

        //Image image = video.getImage();
        //ImageView imageView = (ImageView) button.getGraphic();
        //imageView.setImage(image);

        return button;
    }

    @FXML
    public void initialize()
    {
        profileAvatar.setFill(ProfileDB.currProfile.getColor());
    }

    //TODO:
    // Grouping the pictures
    // Buttons for "film, serier, min liste"
    // functionality for filtering movies
    // showing all the movies
}
