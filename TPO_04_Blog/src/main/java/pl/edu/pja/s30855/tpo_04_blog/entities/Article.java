package pl.edu.pja.s30855.tpo_04_blog.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleID;

    private String title;

    @ManyToOne
    private User author;

    @ManyToOne
    private Blog blog;

    public Article(){}

    public Article(String title, User author, Blog blog){
        this.title = title;
        this.author = author;
        this.blog = blog;
    }

    public Long getArticleID() {
        return articleID;
    }

    public void setArticleID(Long articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String toString() {
        return "User{id=" + articleID + ", author='" + author +  ", blog = "  + blog + "'}";
    }
}
