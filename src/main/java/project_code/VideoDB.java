package project_code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VideoDB extends ImageLoader {

    String movieInfoPath = "src/main/resources/film.txt";
    String seriesInfoPath = "src/main/resources/serier.txt";

    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Series> seriesList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
    }

    public static void initMovieList() throws IOException {

        int loopCount = 0;
        File path = new File("src/main/resources/film.txt");
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("\\s*;\\s*");

        while(scanner.hasNext())
        {
            String title = scanner.next();
            int year = Integer.parseInt(scanner.next());
            String[] genres = scanner.next().split(",\\s*");
            double rating = scanner.nextDouble();

            Movie m = new Movie(title, year, genres, videoCoverList(seriesCoverPath).get(loopCount).toString(), rating);

            movieList.add(m);
            loopCount++;
        }
    }

    //TODO:
    // Fiks initSeriesList() således den udskriver alle oplysninger ordentligt

    public static void initSeriesList() throws IOException
    {
        int loopCount = 0;
        File path = new File("src/main/resources/serier.txt");
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("\\s*;\\s*");

        while(scanner.hasNext())
        {
            String title = scanner.next();
            int year = Integer.parseInt(scanner.next());
            String[] genres = scanner.next().split(",\\s*");
            double rating = scanner.nextDouble();

            Movie m = new Movie(title, year, genres, videoCoverList(seriesCoverPath).get(loopCount).toString(), rating);

            movieList.add(m);
            loopCount++;
        }

    }

    /*
    public static void printMovieList() throws FileNotFoundException
    {
        ArrayList<Video> movieList = listOfMovies();

        for(Video v : listOfMovies())
        {
            System.out.println(v.getInfo());
        }
    }

    final static String filePath = "src/main/resources/film.txt";

    final static Path path = Paths.get("film.txt");

    public static ArrayList<Video> listOfMovies() throws FileNotFoundException {
        ArrayList<Video> movieList = new ArrayList<>();

        BufferedReader br = null;
        try {
            FileReader file = new FileReader(filePath);

            br = new BufferedReader(file);

            String line = br.readLine();

            while (line != null)
            {
                String temp = line.replaceAll(";","_");
                String[] parts = temp.split("_");

                String title = parts[0].trim();

                String year = parts[1].trim();
                int i = Integer.parseInt(year);

                String genres = parts[2].trim();
                String[] genre = genres.split(",");

                String rating = parts[3].trim();
                rating = rating.replace(",",".");
                double d = Double.parseDouble(rating);

                ImageLoader imageLoader = new ImageLoader();

                String posterPath = imageLoader.test(title + ".jpg");

                if (!title.equals("") && !year.equals("") && !genres.equals("") && !rating.equals("")) {
                    assert posterPath != null;

                    if (!posterPath.equals("")) {
                        Movie m = new Movie(title, i, genre, posterPath, d);

                        movieList.add(m);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try
                {
                    br.close();
                } catch (Exception e)
                {
                    System.out.println("Something went wrong");
                }
            }
        }
        return movieList;
    }


     */
}








