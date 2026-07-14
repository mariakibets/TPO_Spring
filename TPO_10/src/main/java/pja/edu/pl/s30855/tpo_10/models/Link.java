package pja.edu.pl.s30855.tpo_10.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Link {

    @Id
    private String Id;
    private String name;

    private String targetUrl;

    private String password;

    private int visits;

    public Link() {}

    public Link(String Id, String name, String targetURL, String password) {
        this.Id = Id;
        this.name = name;
        this.targetUrl = targetURL;
        this.password = password;
        this.visits = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTargetUrl(String targetURL) {
        this.targetUrl = targetURL;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public String getPassword() {
        return password;
    }

    public int getVisits() {
        return visits;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return Id;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public void incrementVisits(){
        this.visits++;
    }
}
