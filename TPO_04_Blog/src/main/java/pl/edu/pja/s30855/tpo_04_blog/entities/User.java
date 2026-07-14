package pl.edu.pja.s30855.tpo_04_blog.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Article> articles = new HashSet<>();
    @OneToOne(mappedBy = "manager", cascade = CascadeType.ALL)
    private Blog managedBlog;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(String email){
        this.email = email;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Blog getManagedBlog() {
        return managedBlog;
    }

    public void setManagedBlog(Blog managedBlog) {
        this.managedBlog = managedBlog;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "User{id=" + userID + ", email='" + email + "'}";
    }


}
