package project_code;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class MainController {

    @FXML
    private Circle profileAvatar;

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
