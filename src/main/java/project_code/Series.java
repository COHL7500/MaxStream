package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

public class Series extends Video {

    private String title;
    private double rating;
    private String runYear;
    private String[] seasons;
    private String[] genres;

    public Series(String title, String runYear, String[] genres, String[] seasons, double rating) {
        this.title = title;
        this.rating = rating;
        this.runYear = runYear;
        this.seasons = seasons;
        this.genres = genres;
    }

    public String getTitle() {
        return this.title;
    }

    public double getRating() {
        return this.rating;
    }

    public String[] getSeasons()
    {
        return this.seasons;
    }

    public Video getVideoType()
    {
        return this;
    }
}
