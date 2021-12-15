package project_code;

import java.util.ArrayList;

public class ProfileDB {

    static private ArrayList<Profile> profileList = new ArrayList<>();

    static public Profile currProfile;

    static public int getProfileListLength()
    {
        return profileList.size();
    }

    static public void removeProfile(Profile profile)
    {
        profileList.remove(profile);
    }

    static public void addProfile(Profile profile)
    {
        profileList.add(profile);
    }

    static Profile getProfile(int index)
    {
        return profileList.get(index);
    }


}
