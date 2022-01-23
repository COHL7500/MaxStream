package project_code;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;

// Definerer hvad objektet "profil" er.

class Profile {

    private int age;
    private Color color;
    private String name;
    //private ArrayList<Video> myList = new ArrayList<>();

    // Her gemmes den bestemte profils liste.
    // Den gemmer objektet af videoen + knappens ID.
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

    Color getColor() {return color;}

    // De nedenstående metoder er overflødige, da vi ikke nåede at bruge dem.
    // Formålet var med getAge, at man kunne filtrere efter brugerens alder.
    // getName kunne bruges på profilsiden, hvor man vil kunne se navnet af brugeren.
    int getAge() {return age;}
    String getName() {return name;}

}
