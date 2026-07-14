package pl.edu.pja.tpo03.tpo_lab_03.model;


import jakarta.persistence.*;

@Entity
public class Entry {

    @Id
    private Long id;
    private String polish;
    private String english;
    private String german;

    public Entry() {}

    public Entry(String polish, String english, String german, Long id) {
        this.id = id;
        this.polish = polish;
        this.english = english;
        this.german = german;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPolish() { return polish; }
    public void setPolish(String polish) { this.polish = polish; }
    public String getEnglish() { return english; }
    public void setEnglish(String english) { this.english = english; }
    public String getGerman() { return german; }
    public void setGerman(String german) { this.german = german; }

    public String toString(){
        return getPolish() + " - " + getEnglish() + " - " + getGerman();
    }
}
