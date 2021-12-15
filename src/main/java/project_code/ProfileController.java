package project_code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project_code.Profile;

import java.io.IOException;

public class ProfileController {

    Stage stage;

    Scene scene;

    @FXML
    public Circle profileAvatar1;

    @FXML
    public Circle profileAvatar2;

    @FXML
    public Circle profileAvatar3;

    @FXML
    public Button profile1Button;

    @FXML
    public Button profile2Button;

    @FXML
    public Button profile3Button;

    @FXML
    private void initialize()
    {

        if(ProfileDB.getProfileListLength() > 0)
        {
            profileAvatar1.setFill(ProfileDB.getProfile(0).getColor());
            profileAvatar1.setOpacity(1);

            if(ProfileDB.getProfileListLength() > 1)
            {
                profileAvatar2.setFill(ProfileDB.getProfile(1).getColor());
                profileAvatar2.setOpacity(1);

                if(ProfileDB.getProfileListLength() > 2)
                {
                    profileAvatar3.setFill(ProfileDB.getProfile(2).getColor());
                    profileAvatar3.setOpacity(1);
                }
            }
        }
    }

    @FXML
    protected void switchToAddProfileScene(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("addProfile-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void switchToMainScene(ActionEvent event) throws IOException
    {
        if(profile1Button == event.getTarget())
        {
            ProfileDB.currProfile = ProfileDB.getProfile(0);
        }
        else if(profile2Button == event.getTarget())
        {
            ProfileDB.currProfile = ProfileDB.getProfile(1);
        }
        else if(profile2Button == event.getTarget())
        {
            ProfileDB.currProfile = ProfileDB.getProfile(2);
        }

        Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}