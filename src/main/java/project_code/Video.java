package project_code;

import javafx.application.Application;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

// Vores overordnede abstrakt-klasse for film/serie.
// Både film/serie nedarver fra Video, eftersom de begge har nogle værdier til fælles.
// Takket være denne struktur, opfylder man Liskovs substitutionsprincip; serier og film kan let udskiftes.

// Jeg forsøgte at implementere den non-primitive datatype Image, da de begge har dette til fælles. Fungererede ikke så godt.

public abstract class Video {

    public abstract Video getVideoType();

    public abstract String getTitle();

    public abstract Double getRating();

    public abstract String[] getGenres();

    public abstract Integer getReleaseYear();



}
