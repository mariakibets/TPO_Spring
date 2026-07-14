package pja.edu.pl.s30855.tpo12.auth;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double price;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors = new ArrayList<>();

    @ManyToOne
    private Publisher publisher;

    public Book() {
    }

    public Book(String title, double price, Publisher publisher) {
        this.title = title;
        this.price = price;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Publisher getPublisherId() {
        return publisher;
    }

    public void setPublisherId(Publisher publisher) {
        this.publisher = publisher;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", authors=" + authors +
                '}';
    }
}
