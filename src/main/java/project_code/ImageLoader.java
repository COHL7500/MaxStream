package project_code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ImageLoader {

    public static void main(String[] args) throws IOException {

        //listOfMovies();

        String temp = "Forrest Gump";

        test(temp + ".jpg");
    }

    public static void listOfMovies() throws IOException
    {
        List<File> filesInFolder = Files.walk(Paths.get("src/main/resources/images/movies"))
                .filter(Files::isRegularFile)
                .map(Path::toFile).toList();

        System.out.println(filesInFolder);

    }

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
