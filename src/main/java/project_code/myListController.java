package project_code;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;

import java.io.IOException;

// Controlleren for siden "Min Liste".
// Controlleren genererer knapper ud fra filmene/serierne, man har tilføjet til sin liste.

public class myListController extends MainController {

    @FXML
    private Circle profileAvatar;

    @FXML
    private TilePane mainTilePane;

    @FXML
    public void initialize() throws IOException {
        profileAvatar.setFill(ProfileDB.currProfile.getColor());

        for(Video videos : ProfileDB.currProfile.getMyList().keySet())
        {
            Button button = buildVideoButton(videos);
            button.setId(Integer.toString(ProfileDB.currProfile.getMyList().get(videos)));
            mainTilePane.getChildren().add(button);
        }

    }
}
