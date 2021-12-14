package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;

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

    public String getInfo()
    {
        String s = ("Title: " + title + "\n" +
                "Release year: " + releaseYear + "\n" +
                "Genres: " + genres + "\n" +
                "IMDB Rating: " + rating);
        return s;


    }

}
