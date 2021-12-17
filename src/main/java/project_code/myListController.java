package project_code;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class myListController extends mainMoviesController {

    @FXML
    private Circle profileAvatar;

    @FXML
    public void initialize()
    {
        profileAvatar.setFill(ProfileDB.currProfile.getColor());
    }
}
