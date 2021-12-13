package project_code;

import java.util.ArrayList;

public class ProfileDB {

    private ArrayList<Profile> profileList;

    public ProfileDB()
    {
        this.profileList = new ArrayList<>();
    }

    void removeProfile(Profile profile)
    {
        profileList.remove(profile);
    }

    void addProfile(Profile profile)
    {
        profileList.add(profile);
    }

    Profile getProfile(int index)
    {
        return profileList.get(index);
    }
}
