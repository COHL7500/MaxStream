package project_code;

import javafx.scene.image.Image;

public class Movie extends Video {

    String title;
    int releaseYear;
    String[] genres;
    double rating;
    Image coverImage;

    public Movie(String title, int release, String[] genres, double rating)
    {
        this.title = title;
        this.releaseYear = release;
        this.genres = genres;
        this.rating = rating;
        //this.coverImage = image;
        //this.coverImage = new Image(imgPath, true);
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
