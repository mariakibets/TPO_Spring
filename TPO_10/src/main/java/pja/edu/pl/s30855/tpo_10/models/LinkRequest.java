package pja.edu.pl.s30855.tpo_10.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import pja.edu.pl.s30855.tpo_10.Annotation.Password;

import javax.xml.transform.Source;

public class LinkRequest {


    @NotBlank
    @Size(min = 2)
    private String name;

    @NotBlank
    @URL
    private String targetUrl;


    @Password
    private String password;

    public LinkRequest(){}

    public LinkRequest(String name,String targetUrl, String password){
        this.name = name;
        this.password = password;
        this.targetUrl = targetUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
