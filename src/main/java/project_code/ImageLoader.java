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

       // listOfMovies();

        String temp = "2001 A Space Odyssey";

        test2(temp + ".jpg");
    }

    public static List<File> listOfMovies() throws IOException
    {
        List<File> filesInFolder = Files.walk(Paths.get("src/main/resources/images/movies"))
                .filter(Files::isRegularFile)
                .map(Path::toFile).toList();



        for (int i = 0; i <filesInFolder.size(); i++)
        {
            //System.out.println(filesInFolder.get(i));
            //System.out.println(folderFiles);
        }

        return filesInFolder;
    }

    public static String test2(String fileName) throws NullPointerException, IOException {


        List<File> listOfMovies = listOfMovies();

        for (File f: listOfMovies)
        {
            if (f.isFile())
            {
                if(f.getName().equals(fileName))
                {
                    System.out.println(f.getPath());
                    return f.getPath();
                }

            }
        }
        System.out.println(listOfMovies);
        return listOfMovies.toString();
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
                    //System.out.println(fileName);
                    System.out.println(listOfFiles);
                    return file.getPath();
                    //return "src/main/resources/images/movies/" + fileName;
                }

            }
        }
        //System.out.println("No filename found");
        System.out.println(movieList);
        return movieList.toString();
    }

}
