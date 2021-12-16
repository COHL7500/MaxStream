package project_code;

import javafx.scene.image.Image;

import java.net.URISyntaxException;
import java.util.Arrays;

public class Movie extends Video {

    private String title;
    private int releaseYear;
    private String[] genres;
    private double rating;

    public Movie(String title, int release, String[] genres, double rating) {
        this.title = title;
        this.releaseYear = release;
        this.genres = genres;
        this.rating = rating;

    }

    public String getTitle() {return this.title;}

    public Video getVideoType() {
        return this;
    }

    public double getRating() { return this.rating; }

    public  int getReleaseYear() {return this.releaseYear;}

}
