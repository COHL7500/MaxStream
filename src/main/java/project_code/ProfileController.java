package project_code;
import javafx.scene.paint.Color;

import java.util.*;
import javafx.scene.paint.Color;

public class ProfileController
{
    ArrayList<Object> profiles = new ArrayList<>();
    Color profileColor;

    public void newProfile(String name, Color color, int r, int g, int b)
    {
        Object profile = new Object();
        profiles.add(profile);
        System.out.println(profiles);
    }
}