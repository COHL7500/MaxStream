package project_code;

//import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import java.util.Map;

public class VideoDB {

   // HashMap<Video, Button> videoDB = new HashMap<Video, Button>();

    public void videoDB()
    {
    }

    final static String filePath = "temp.txt";

    public static ArrayList<Video> listOfMovies() throws FileNotFoundException {
        ArrayList<Video> movieList = new ArrayList<>();

        BufferedReader br = null;
        try {
            FileReader file = new FileReader(filePath);

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

                double d = Double.parseDouble(rating);

                if (!title.equals("") && !year.equals("") && !genres.equals("") && !rating.equals(""))
                {
                    Movie m = new Movie(title, i, genre, "", d);

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
                }
            }
        }
        return movieList;
    }

}







