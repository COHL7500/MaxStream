package project_code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

// Controlleren for siden "AddProfile"-siden.
// Denne side opretter brugeren og gemmer oplysningerne indtastet i VideoDB.

public class addProfileController extends SceneController {

    Stage stage;
    Scene scene;

    @FXML
    private ColorPicker avatarColorPicker;

    @FXML
    private Circle AVATAR;

    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private Text warnText;

    // Ja.. denne her burde slettes. Intet initialiseres.
    // Når noget indtastes i denne metode, bliver indholdende kode kørt som det første.
    @FXML
    protected void initialize()
    {
    }

    @FXML
    protected void setTempAvatarColor() // changes color of avatar in addProfile
    {
        AVATAR.setFill(avatarColorPicker.getValue());
    }

    // Opretter profilen. Sørger for alle oplysninger opfylder minimumskravene.
    @FXML
    protected void createAccount(ActionEvent event) throws IOException {

        if(ProfileDB.getProfileListLength() == 3)
        {

            warnText.setText("Cannot create more users!");

            warnText.setOpacity(1.0);

        }
        else if (nameField.getText().equals("") || ageField.getText().equals("")) {

            warnText.setText("Field cannot be empty!");

            warnText.setOpacity(1.0);

        } else if (nameField.getLength() > 10) {

            warnText.setText("Name is too long!");

            warnText.setOpacity(1.0);

        } else if (ageField.getLength() > 4) {

            warnText.setText("Age is too high!");

            warnText.setOpacity(1.0);

        } else if (nameField.getText().matches(".*[0-9].*") || nameField.getText().matches(".*[^a-z0-9].*")) {

            nameField.clear();

            warnText.setText("Name must only contain letters!");

            warnText.setOpacity(1.0);

        } else if (!ageField.getText().matches(".*[0-9].*")) {

            ageField.clear();

            warnText.setText("Age cannot contain letters!");

            warnText.setOpacity(1.0);

        } else {

            // Når alle minimumskravene er opfyldt, oprettes profilen og gemmes til ProfileDB.

            Profile profile = new Profile(Integer.parseInt(ageField.getText()),
                    avatarColorPicker.getValue(),
                    nameField.getText());

            ProfileDB.addProfile(profile);

            System.out.println(ProfileDB.getProfileListLength());

            // Alt koden nedenstående burde udskiftes med SceneControllers funktion "switchToProfile".
            // Koden er kodeduplikering er forfærdelig praksis.
            Parent root = FXMLLoader.load(getClass().getResource("profile-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }
}
