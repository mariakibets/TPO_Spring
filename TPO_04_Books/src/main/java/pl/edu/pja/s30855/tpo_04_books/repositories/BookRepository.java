package pl.edu.pja.s30855.tpo_04_books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pja.s30855.tpo_04_books.Entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
