package project_code;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ImageLoader {

    public static String movieCoverPath = "src/main/resources/images/movies";

    public static String seriesCoverPath = "src/main/resources/images/series";


    public static void main(String[] args) throws IOException {

        /*
        System.out.println(videoCoverList(movieCoverPath));

        System.out.println(videoCoverList(movieCoverPath).get(3));

        System.out.println(videoCoverList(movieCoverPath).size());

         */

        myTest.getAnyFile("The Wizard Of Oz.jpg");
        //test("2001 A Space Odyssey" + ".jpg");
    }



    public static List videoCoverList(String filePath) throws IOException
    {
        List<File> filesInFolder = Files.walk(Paths.get(filePath)).sorted()
                .filter(Files::isRegularFile)
                .map(Path::toFile).toList();

        return filesInFolder;

    }

    public static String findPath(String fileName) throws NullPointerException
    {
        File folder = new File("src/main/resources/images/movies");
        File[] listOfFiles = folder.listFiles();


        assert listOfFiles != null;
        for (File file : listOfFiles)
        {
            if (file.isFile() && file.getName().equals(fileName))
            {
                return file.getPath();
            }
        }
        return "No filename found";
    }




    public static class myTest
    {
        @Test
        public static void getAnyFile(String fileName) throws NullPointerException
        {
            ImageLoader testing = new ImageLoader();
            boolean testSucces = false;

            String filename = null;

            filename = fileName;

            String anyFileName = ImageLoader.findPath(filename);

            System.out.println(anyFileName);

            assert anyFileName != null;
            if(anyFileName == "No filename found")
            {
                testSucces = false;
                assertFalse(testSucces);
            } else
            {
                testSucces = true;
                assertTrue(testSucces);
            }
    }








    }

}
