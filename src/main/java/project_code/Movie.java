package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Movie extends Video {

    String title;
    Image coverImage;
    String description;
    int rating;
    String releaseDate;
    ArrayList<String> genres;


    public Movie(String title, String imgPath, String desc, int rating, String release)
    {
        this.title = title;
        this.coverImage = new Image(imgPath, true);
        this.description = desc;
        this.rating = rating;
        this.releaseDate = release;
        this.genres = new ArrayList<>();
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
