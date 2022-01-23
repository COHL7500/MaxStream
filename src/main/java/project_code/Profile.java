package project_code;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

class Profile {

    private int age;
    private Color color;
    private String name;
    //private ArrayList<Video> myList = new ArrayList<>();
    private HashMap<Video, Integer> myList = new HashMap<>();

    //TODO:
    // - Read all user data from a file
    // - Load color from file path
    // - Add and remove from list

    public Profile(int age, Color color, String name)
    {
        this.age = age;
        this.color = color;
        this.name = name;
    }

    HashMap<Video, Integer> getMyList() {return myList;}

    void addToMyList(Video video, Integer integer) {myList.put(video, integer);}

    int getAge() {return age;}
    Color getColor() {return color;}
    String getName() {return name;}

}
