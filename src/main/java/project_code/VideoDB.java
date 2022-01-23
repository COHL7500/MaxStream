package project_code;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

// En databasemodel for alle videoer: Liste for de respektive film, serier, genrer osv.
//TODO:
// Arrays frem for ArrayListe (overflødigt, siden de har en fast længde alligevel).
// Et mere optimalt system til at gemme den nuværende video.
// Færre lister
// Mere optimal konstruering/opsætning af listerne.

public class VideoDB extends ImageLoader {

    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Series> seriesList = new ArrayList<>();
    private static ArrayList<Video> videoList = new ArrayList<>();
    private static ArrayList<String> genreList = new ArrayList<>();

    public static int currentlyShownVideo = 0;

    // Getter-metoder til at få fat på listerne.

    public static ArrayList<String> getGenreList()
    {
        return genreList;
    }

    public static ArrayList<Movie> getMovieList()
    {
        return movieList;
    }

    public static ArrayList<Series> getSeriesList()
    {
        return seriesList;
    }

    public static ArrayList<Video> getVideoList()
    {
        return videoList;
    }

    // Build-metoder for at bygge listerne. Garanteret en bedre løsning.
    // ... De kan smide en checked exception, altså IOException, siden de bruger "scanner".
    /// ... Hvis man ændrer txt-filerne med data, som ikke stemmer overens, vil den kaste en IOException.
    // ... Denne exception kunne godt propageres og angive info til kalderen. Dette nåede vi ikke at implementere.


    public static ArrayList<Movie> buildMovieList() throws IOException {

        File path = new File("src/main/resources/film.txt");
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("\\s*;\\s*");

        while(scanner.hasNext())
        {
            String title = scanner.next();
            int year = Integer.parseInt(scanner.next());
            String[] genres = scanner.next().split(",\\s*");
            double rating = scanner.nextDouble();

            Movie m = new Movie(title, year, genres, rating);

            movieList.add(m);
        }

        return movieList;
    }

    public static ArrayList<Series> buildSeriesList() throws IOException
    {

        File path = new File("src/main/resources/serier.txt");
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("\\s*;\\s*");

        while (scanner.hasNext()) {
            String title = scanner.next();
            String[] year = scanner.next().split("-");

            int yearStart =  Integer.parseInt(year[0]);
            int yearEnd = 0;

            if (year.length > 1) yearEnd = Integer.parseInt(year[1]);


            String[] genres = scanner.next().split(",\\s*");
            double rating = scanner.nextDouble();
            String[] seasons = scanner.next().split(",\\s*");

            Series s = new Series(title, yearStart, yearEnd, genres, seasons, rating);

            seriesList.add(s);
        }

        return seriesList;

    }

    public static void buildGenreList()
    {
        // Film-exclusives
        genreList.add("Film-noir");
        genreList.add("Musical");
        genreList.add("Music");
        // Alle tilfælles
        genreList.add("Crime");
        genreList.add("Drama");
        genreList.add("History");
        genreList.add("Romance");
        genreList.add("Thriller");
        genreList.add("Adventure");
        genreList.add("Comedy");
        genreList.add("War");
        genreList.add("Action");
        genreList.add("Sport");
        genreList.add("Sci-fi");
        genreList.add("Western");
        genreList.add("Biography");
        genreList.add("Mystery");
        genreList.add("Fantasy");
        genreList.add("Horror");
        // Serier-exclusives
        genreList.add("Animation");
        genreList.add("Documentary");
        genreList.add("Family");
        genreList.add("Talk show");
    }

    public static ArrayList<Video> buildVideoList()
    {
        videoList.addAll(getMovieList());
        videoList.addAll(getSeriesList());

        return videoList;
    }
}








