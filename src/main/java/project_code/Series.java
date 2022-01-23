package project_code;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;

// Definerer hvad et serie-objekt indeholder.

public class Series extends Video {

    private String title;
    private Double rating;
    private int yearStart;
    private int yearEnd;
    private String[] seasons;
    private String[] genres;

    public Series(String title, int yearStart, int yearEnd, String[] genres, String[] seasons, double rating) {
        this.title = title;
        this.rating = rating;
        this.yearStart = yearStart;
        this.yearEnd = yearEnd;
        this.seasons = seasons;
        this.genres = genres;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getRating() {
        return this.rating;
    }

    public String[] getSeasons()
    {
        return this.seasons;
    }

    public String[] getGenres() { return this.genres; }

    @Override
    public Integer getReleaseYear() { return this.yearStart; }

    public Integer getYearEnd() { return this.yearEnd; }

    public Video getVideoType()
    {
        return this;
    }
}
