package pl.edu.pja.tpo02.model;

public class Entry {

    private String polish;
    private String german;
    private String english;

    public Entry(String polish, String english, String german){
        this.polish = polish;
        this.german = german;
        this.english = english;
    }

    public String getEnglish() {return english;}

    public String getPolish () {return polish;}

    public String getGerman() {return german;}

    @Override
    public String toString() {
        return polish + " - " + english + " - " + german;
    }
}
