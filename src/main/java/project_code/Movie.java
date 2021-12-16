package project_code;

import javafx.scene.image.Image;

import java.net.URISyntaxException;
import java.util.Arrays;

public class Movie extends Video {

    private String title;
    private int releaseYear;
    private String[] genres;
    private double rating;
    private Image coverImage;

    public Movie(String title, int release, String[] genres, String imagePath, double rating) {
        this.title = title;
        this.releaseYear = release;
        this.genres = genres;
        this.rating = rating;
        this.coverImage = new Image("file:" + imagePath);

    }

    public Video getVideoType() {
        return this;
    }


    public Image getImage() { return this.coverImage; }

}
