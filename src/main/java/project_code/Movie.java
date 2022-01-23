package project_code;

// Definerer hvad et film-objekt er.

public class Movie extends Video {

    private String title;
    private int releaseYear;
    private String[] genres;
    private Double rating;

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

    public Double getRating() { return this.rating; }

    public String[] getGenres() { return this.genres; }

    @Override
    public Integer getReleaseYear() {return this.releaseYear;}

}
