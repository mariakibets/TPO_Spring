package pl.edu.pja.s30855.tpo_04_books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pja.s30855.tpo_04_books.Entities.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
