package pja.edu.pl.s30855.tpo_10.models;

public class LinkResponse {

    private String Id;

    private String name;

    private String targetURL;

    private String redirectUrl;

    private int visits;

    public LinkResponse(){}

    public LinkResponse (String Id, String name, String targetURL, String redirectUrl, int visits) {
        this.Id = Id;
        this.name = name;
        this.targetURL = targetURL;
        this.redirectUrl = redirectUrl;
        this.visits = visits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTargetURL() {
        return targetURL;
    }

    public void setTargetURL(String targetURL) {
        this.targetURL = targetURL;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getVisits() {
        return visits;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }



    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
