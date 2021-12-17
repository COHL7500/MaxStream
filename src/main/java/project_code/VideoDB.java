package project_code;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

public class VideoDB extends ImageLoader {

    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Series> seriesList = new ArrayList<>();
    private static ArrayList<Video> videoList = new ArrayList<>();
    private static HashMap<Video, Button> currButtonList;

    public static int currentlyShownVideo = 0;

    public static HashMap<Video, Button> getCurrButtonList() {return currButtonList;}

    public static void putCurrButtonList(Video video, Button button) {currButtonList.put(video, button);}


    public static ArrayList<Movie> getMovieList() throws IOException
    {
        return movieList;
    }

    public static ArrayList<Series> getSeriesList() throws IOException
    {
        return seriesList;
    }

    public static ArrayList<Video> getVideoList() throws IOException
    {
        return videoList;
    }

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

    public static ArrayList<Video> buildVideoList() throws IOException
    {
        videoList.addAll(getMovieList());
        videoList.addAll(getSeriesList());

        return videoList;
    }
}








