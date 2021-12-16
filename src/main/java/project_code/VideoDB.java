package project_code;

import javafx.scene.image.Image;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class VideoDB extends ImageLoader {

    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Series> seriesList = new ArrayList<>();
    private static ArrayList<Video> videoList = new ArrayList<>();

    public static ArrayList<Movie> initMovieList() throws IOException {

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

    public static ArrayList<Series> initSeriesList() throws IOException
    {

        File path = new File("src/main/resources/serier.txt");
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("\\s*;\\s*");

        while (scanner.hasNext()) {
            String title = scanner.next();
            String year = scanner.next().replace(" ", "");
            String[] genres = scanner.next().split(",\\s*");
            double rating = scanner.nextDouble();
            String[] seasons = scanner.next().split(",\\s*");

            Series m = new Series(title, year, genres, seasons, rating);

            seriesList.add(m);
        }

        return seriesList;

    }

    public static ArrayList<Video> initVideoList() throws IOException
    {
        videoList.addAll(initMovieList());
        videoList.addAll(initSeriesList());

        return videoList;
    }
}








