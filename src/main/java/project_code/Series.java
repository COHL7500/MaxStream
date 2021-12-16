package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Series extends Video {

    private String title;
    private Image coverImage;
    private double rating;
    private int releaseYearStart;
    private int releaseYearEnd;
    private String[] seasons;
    private String[] genres;

    public Series(String title, int relYearStart, int relYearEnd, String[] genres, String[] seasons, String imagePath, double rating)
    {
        this.title = title;
        this.coverImage = new Image("file:" + imagePath);
        this.rating = rating;
        this.releaseYearStart = relYearStart;
        this.releaseYearEnd = relYearEnd;
        this.seasons =
        this.genres = genres;
    }

    public Video getVideoType()
    {
        return this;
    }

    public Image getImage()
    {
        return this.coverImage;
    }

    @Override
    public String getInfo() // Egnet til testing
    {
        String s = ("Title: " + title + "\n" +
                "Release year: " + releaseYear + "\n" +
                "Final year: " + releaseYearEnd + "\n" +
                "Genres: " + Arrays.toString(genres) + "\n" +
                "IMDB Rating: " + rating + "\n" + "---------------");

        return s;
    }
}
