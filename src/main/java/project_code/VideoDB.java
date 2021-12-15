package project_code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class VideoDB {

    public static void main(String[] args) throws FileNotFoundException {
        printMovieList();
    }

    //HashMap<Video, Button> videoDB = new HashMap<Video, Button>();

    public static void printMovieList() {
        ArrayList<Video> movieList = listOfMovies();

        for(Video v : movieList)
        {
            System.out.println(v.getInfo());
        }
    }

    final static String filePath = "src/main/resources/film.txt";

    public static ArrayList<Video> listOfMovies() {
        ArrayList<Video> movieList = new ArrayList<>();

        BufferedReader br = null;
        try {
            FileReader file = new FileReader(filePath);

            br = new BufferedReader(file);

            String line = br.readLine();

            //String temp2 = line.replaceAll(";","'");



            while ((line = br.readLine()) != null)
            {
                //String temp = line.replaceAll(";","'");
                String[] parts = line.split(";");

                String title = parts[0].trim();

                String year = parts[1].trim();
                int i = Integer.parseInt(year);

                String genres = parts[2].trim();
                String[] genre = genres.split(",");

                String rating = parts[3].trim();
                rating = rating.replace(",",".");
                double d = Double.parseDouble(rating);

                String posterPath = ImageLoader.test2(title + ".jpg");

                if (!title.equals("") && !year.equals("") && !genres.equals("") && !rating.equals("")) {

                    Movie m = new Movie(title, i, genre, posterPath, d);

                    movieList.add(m);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
                    e.printStackTrace();
                    System.out.println("Something went wrong");
                }
            }
        }
        System.out.println(movieList);
        return movieList;
    }

}







