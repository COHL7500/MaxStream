package project_code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ImageLoader {

    public static String movieCoverPath = "src/main/resources/images/movies";

    public static String seriesCoverPath = "src/main/resources/images/series";

    /*
    public static void main(String[] args) throws IOException {

        System.out.println(videoCoverList(movieCoverPath));

        System.out.println(videoCoverList(movieCoverPath).get(3));

        System.out.println(videoCoverList(movieCoverPath).size());
    }
     */


    public static List videoCoverList(String filePath) throws IOException
    {
        List<File> filesInFolder = Files.walk(Paths.get(filePath)).sorted()
                .filter(Files::isRegularFile)
                .map(Path::toFile).toList();

        return filesInFolder;

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
