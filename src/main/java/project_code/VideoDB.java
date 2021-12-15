package project_code;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class VideoDB {

    public static void main(String[] args) throws FileNotFoundException {
        printMovieList();
    }

    public static void printMovieList() throws FileNotFoundException
    {
        ArrayList<Video> movieList = listOfMovies();

        for(Video v : movieList)
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

            String line = null;

            while ((line = br.readLine()) != null)
            {
                String temp = line.replaceAll(";","'");
                String[] parts = temp.split("'");


                String title = parts[0].trim();

                String year = parts[1].trim();
                int i = Integer.parseInt(year);

                String genres = parts[2].trim();
                String[] genre = genres.split(",");

                String rating = parts[3].trim();
                rating = rating.replace(",",".");
                double d = Double.parseDouble(rating);

                ImageLoader imageLoader = new ImageLoader();

                String posterPath = ImageLoader.test(title + ".jpg");

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

}







