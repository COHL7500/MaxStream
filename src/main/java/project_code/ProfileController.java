package project_code;
import java.util.*;

public class ProfileController
{
    public ArrayList profiles;

    public void OnStart()
    {
        profiles = new ArrayList();

    }

    public void addProfile(String name)
    {
        profiles.add(name);
    }

}