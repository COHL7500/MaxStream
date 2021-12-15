package project_code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class VideoDB {

    public static void main(String[] args) throws FileNotFoundException {
        printMovieList();
    }

    //HashMap<Video, Button> videoDB = new HashMap<Video, Button>();

    public static void printMovieList()throws FileNotFoundException
    {
        for(Video v : listOfMovies())
        {
            System.out.println(v.getInfo());
        }
    }

    public void videoDB()
    {

    }

    final static String filePath = "src/main/resources/film.txt";

    final static Path path = Paths.get("film.txt");



    public static ArrayList<Video> listOfMovies() throws FileNotFoundException {
        ArrayList<Video> movieList = new ArrayList<>();

        BufferedReader br = null;
        try {
            FileReader file;
            file = new FileReader(filePath);

            br = new BufferedReader(file);

            String line = null;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                String title = parts[0].trim();
                String year = parts[1].trim();

                int i = Integer.parseInt(year);

                String genres = parts[2].trim();
                String[] genre = genres.split(",");

                String rating = parts[3].trim();
                rating = rating.replace(",",".");
                double d = Double.parseDouble(rating);

                String name = title + ".jpg";

                //File tempfile = new File("src\\main\\resources\\images\\movies\\" + title + ".jpg");

                //String tempString = "" + title + ".jpg";

                //Image image = new Image(tempString, true);



                if (!title.equals("") && !year.equals("") && !genres.equals("") && !rating.equals(""))
                {
                    Movie m = new Movie(title, i, genre, d);

                    movieList.add(m);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } finally {
            if (br != null) {
                try
                {
                    br.close();
                } catch (Exception e)
                {
                    e.getMessage();
                }
            }
        }
        return movieList;
    }

}







