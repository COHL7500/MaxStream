package project_code;

import java.util.ArrayList;

public class ProfileDB {

    // Burde være et almindelig Array, siden profillisten kan kun være 4 profiler lang.
    // Dårlig praksis.
    static private ArrayList<Profile> profileList = new ArrayList<>();

    static public Profile currProfile;

    // Skulle være en Getter-metode til profileList i stedet for bare size.
    // Dårlig praksis.
    static public int getProfileListLength()
    {
        return profileList.size();
    }


    // Fjerner en profil fra listen.
    // Funktionen anvendes ikke, dog var det meningen, at man skulle have haft muligheden for at fjerne en profil.
    static public void removeProfile(Profile profile)
    {
        profileList.remove(profile);
    }

    // Tilføjer en profil til listen.
    static public void addProfile(Profile profile)
    {
        profileList.add(profile);
    }

    // Getter-metode til at få alle profiler.
    static Profile getProfile(int index)
    {
        return profileList.get(index);
    }


}
