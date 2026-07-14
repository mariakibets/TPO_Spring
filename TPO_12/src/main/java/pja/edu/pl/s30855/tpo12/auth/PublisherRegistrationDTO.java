package pja.edu.pl.s30855.tpo12.auth;

public class PublisherRegistrationDTO {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String publisherName;

    public PublisherRegistrationDTO(){}
    public PublisherRegistrationDTO(String username, String email, String password, String confirmPassword, String publisherName){
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.publisherName = publisherName;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

}

