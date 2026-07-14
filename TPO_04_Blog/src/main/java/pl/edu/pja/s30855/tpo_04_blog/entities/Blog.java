package pl.edu.pja.s30855.tpo_04_blog.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long blogID;

    private String name;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private Set<Article> articles = new HashSet<>();

    @OneToOne
    private User manager;

    public Blog(){}

    public Blog(String name, User manager){
        this.name = name;
        this.manager = manager;
    }

    public Long getBlogID() {
        return blogID;
    }

    public void setBlogID(Long blogID) {
        this.blogID = blogID;
    }

    public String getName() {
        return name;
    }


    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getManager() {
        return manager;
    }

    public String toString() {
        return "User{id=" + blogID + ", name ='" + name + ", manager =" + manager + "'}";
    }
}
