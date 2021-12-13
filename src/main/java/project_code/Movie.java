package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Movie extends Video {

    String title;
    int releaseYear;
    String[] genres;
    double rating;
    Image coverImage;


    public Movie(String title, int release, String[] genres, String imgPath, double rating)
    {
        this.title = title;
        this.releaseYear = release;
        this.genres = genres;
        this.rating = rating;
        this.coverImage = new Image(imgPath, true);
    }

    @Override
    public Video getVideoType() {
        return this;
    }

    @Override
    public Image getImage() {
        return coverImage;
    }
}
