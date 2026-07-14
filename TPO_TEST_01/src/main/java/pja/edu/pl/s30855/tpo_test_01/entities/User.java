package pja.edu.pl.s30855.tpo_test_01.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    private String password;

    @Email
    private String email;

    public User(){}

    public User (Long Id, String name, String password, String email){
        this.Id = Id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        Id = id;
    }
}

