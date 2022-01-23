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
import java.util.HashMap;
import java.util.Objects;

public class MainController extends SceneController {

    // Erklæring og initialisering af relevante variabler

    static Stage stage;

    static Scene scene;

    @FXML
    public Circle profileAvatar;

    @FXML
    public TilePane mainTilePane;

    public HashMap<Video, Button> genreIncludedMap = new HashMap<>();

    public HashMap<Video, Button> genreExcludedMap = new HashMap<>();


    // Genererer knap for hver medie/video, der eksisterer (dvs. alle film og serier).
    @FXML
    protected static Button buildVideoButton(Video video) throws IOException
    {

        // Indlæser knappens fxml-fil og indlæser den som en knap.
        FXMLLoader buttonLoader = new FXMLLoader(ITUStreamApplication.class.getResource("videobutton.fxml"));
        Button button = buttonLoader.load();

        // Indlæser billedet/thumbnailen tilhørende videoen.
        Image image = ImageLoader.imageFinder(video);
        ImageView imageView = (ImageView) button.getGraphic();
        imageView.setImage(image);

        // Knappen får funktionalitet: Når man klikker på knappen, vis siden for den gældende serier eller film.
        button.setOnAction(event -> {
            Parent root = null;
            // Hver knap har et ID. ID'et stemmer overens med indekset for den gældende film i videolisten.
            VideoDB.currentlyShownVideo = Integer.parseInt(button.getId());
            // Til debugging; ikke påkrævet. Bruges til at teste, om der er præcis 200 knapper.
            System.out.println(VideoDB.currentlyShownVideo);

            // Undersøger, om det gældende objekt tilhørende "video" er en serie eller film.
            // .. Hvis typen er film: Vis siden for film.
            // .. Hvis typen er serier: Vis siden for serier.
            try {
                root = FXMLLoader.load(Objects.requireNonNull(ITUStreamApplication.class.getResource(
                        video.getVideoType() instanceof Series ? "showSeries.fxml" : "showMovie.fxml")));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Scenen udskiftes.
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
