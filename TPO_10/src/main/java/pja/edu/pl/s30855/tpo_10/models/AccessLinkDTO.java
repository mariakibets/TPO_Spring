package pja.edu.pl.s30855.tpo_10.models;

import jakarta.validation.constraints.NotBlank;

public class AccessLinkDTO {

    @NotBlank()

    private String name;

    @NotBlank()
    private String password;

    public AccessLinkDTO(String name, String password){
        this.name = name;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
