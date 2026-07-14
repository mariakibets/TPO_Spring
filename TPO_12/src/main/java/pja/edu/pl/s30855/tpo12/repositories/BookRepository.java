package pja.edu.pl.s30855.tpo12.repositories;

import org.springframework.data.repository.CrudRepository;
import pja.edu.pl.s30855.tpo12.auth.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByTitleContainingIgnoreCase(String keyword);
    List<Book> findByPublisher_Name(String publisherName);

    List<Book> findAll();
}
