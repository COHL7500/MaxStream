package project_code;

import java.util.ArrayList;

class Profile {

    int age;
    String color;
    String name;
    boolean kidsAcc;
    ArrayList<Video> videoList = new ArrayList<Video>();

    //TODO:
    // - Read all user data from a file
    // - Load color from file path
    // - Add and remove from list

    public Profile(int age, String color, String name)
    {
        this.age = age;
        this.color = color;
        this.name = name;
        this.kidsAcc = age < 18;
    }
}
