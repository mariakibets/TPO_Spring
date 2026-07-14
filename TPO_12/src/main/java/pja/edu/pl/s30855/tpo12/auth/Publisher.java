package pja.edu.pl.s30855.tpo12.auth;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    private String name;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Book> books = new ArrayList<>();

    public Publisher(){}

    public Publisher(String name){
        this.name = name;
    }


    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + publisherId +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}

