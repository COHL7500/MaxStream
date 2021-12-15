package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Series extends Video {

    String title;
    Image coverImage;
    double rating;
    int releaseYear;
    ArrayList<String> genres;
    ArrayList<String> episodes;

    public Series(String title, Image image, double rating, int relYear, ArrayList<String> genres)
    {
        this.title = title;
        this.coverImage = image;
        this.rating = rating;
        this.releaseYear = relYear;
        this.genres = genres;
        this.episodes = new ArrayList<>();
    }

    @Override
    public Video getVideoType()
    {
        return this;
    }

    @Override
    public Image getImage()
    {
        return this.coverImage;
    }

    @Override
    public String getInfo()
    {
        String s = ("Title: " + title + "\n" +
                "Release year: " + releaseYear + "\n" +
                "Genres: " + genres + "\n" +
                "IMDB Rating: " + rating);
        return s;
    }
}
