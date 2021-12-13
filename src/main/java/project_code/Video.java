package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;

public abstract class Video {

    // Man kunne eventuelt have skuespillere inkluderet, dog skulle man tjekke det for alle 100 film.

    String title;
    String coverImage;
    String description;
    int rating;
    String releaseYear;
    ArrayList<String> genres;

    // Skal være mere konkret end "Object".
    // Skal returnere en videotype, f.eks. serie/profil
    public abstract Video getVideoType();

    public abstract Image getImage();


}
