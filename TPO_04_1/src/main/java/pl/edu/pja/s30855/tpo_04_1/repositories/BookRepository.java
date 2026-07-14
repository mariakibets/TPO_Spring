package pl.edu.pja.s30855.tpo_04_1.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pja.s30855.tpo_04_1.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    
}
