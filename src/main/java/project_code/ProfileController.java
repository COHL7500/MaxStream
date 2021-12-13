package project_code;
import javafx.scene.paint.Color;

import java.util.*;
import javafx.scene.paint.Color;

public class ProfileController
{
    String name;
    String color;
    int age;
    Boolean kidAcc;

    ArrayList<Object> profiles = new ArrayList<>();

    public Object Profile(String name, String color, int age, boolean kidAcc)
    {
        this.name = name;
        this.color = color;
        this.age = age;
        this.kidAcc = kidAcc;
        if (age < 12)
        {
            kidAcc = true;
        } else {kidAcc = false;}

        return null;
    }
    public void addProfile()
    {
        profiles.add(Profile(name, color, age, kidAcc));
    }
}