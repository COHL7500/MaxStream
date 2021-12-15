package project_code;

import javafx.scene.image.Image;

import java.net.URISyntaxException;

public class Movie extends Video {

    String title;
    int releaseYear;
    String[] genres;
    double rating;
    Image coverImage;
    String imagePath;

    public Movie(String title, int release, String[] genres,String imgPath, double rating) throws URISyntaxException {
        this.title = title;
        this.releaseYear = release;
        this.genres = genres;
        this.rating = rating;
        this.imagePath = imgPath;
        coverImage = new Image(getClass().getResource(imgPath).toURI().toString());

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
