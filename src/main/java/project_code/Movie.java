package project_code;

import java.util.ArrayList;

public class Movie extends Video {

    String title;
    String coverImage;
    String description;
    int rating;
    String releaseDate;
    ArrayList<String> genres;


    public Movie(String title, String cover, String desc, int rating, String release)
    {
        this.title = title;
        this.coverImage = cover;
        this.description = desc;
        this.rating = rating;
        this.releaseDate = release;
        this.genres = new ArrayList<>();
    }


}
