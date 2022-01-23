package project_code;

import javafx.application.Application;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Video {
    // Skal være mere konkret end "Object".
    // Skal returnere en videotype, f.eks. serie/profil
    public abstract Video getVideoType();

    public abstract String getTitle();

    public abstract Double getRating();

    public abstract String[] getGenres();

    public abstract Integer getReleaseYear();



}
