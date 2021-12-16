package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Video {

    // Man kunne eventuelt have skuespillere inkluderet, dog skulle man tjekke det for alle 100 film.

    String title;
    int releaseYear;
    String[] genres;
    double rating;
    Image coverImage;

    // Skal være mere konkret end "Object".
    // Skal returnere en videotype, f.eks. serie/profil
    public abstract Video getVideoType();

    public abstract Image getImage();

    public String getInfo() // Egnet til testing
    {
        String s = ("Title: " + title + "\n" +
                "Release year: " + releaseYear + "\n" +
                "Genres: " + Arrays.toString(genres) + "\n" +
                "IMDB Rating: " + rating + "\n" + "---------------");

        return s;
    }


}
