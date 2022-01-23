package project_code;

import javafx.application.Application;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ImageLoader {

    public static Image imageFinder(Video video) throws IOException
    {
        String folder = video.getVideoType() instanceof Series ? "series" : "movies";
        String path = "/images/" + folder + "/" + video.getTitle() + ".jpg";
        URL finalPath = ITUStreamApplication.class.getResource(path);
        assert finalPath != null;
        return new Image(finalPath.toExternalForm());
    }

    // denne bruges aldrig: Var en test
    public static String test(String fileName) throws NullPointerException
    {
        File folder = new File("src/main/resources/images/movies");
        File[] listOfFiles = folder.listFiles();
        ArrayList<File> movieList = new ArrayList<>();


        assert listOfFiles != null;
        for (File file : listOfFiles)
        {
            if (file.isFile())
            {
                movieList.add(file);

                if(file.getName().equals(fileName))
                {
                    System.out.println(fileName);
                    return file.getPath();
                    //return "src/main/resources/images/movies/" + fileName;
                }

            }
        }
        System.out.println("No filename found");
        return null;
    }

}
