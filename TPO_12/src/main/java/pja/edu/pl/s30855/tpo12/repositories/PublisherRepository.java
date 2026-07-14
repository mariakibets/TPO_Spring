package pja.edu.pl.s30855.tpo12.repositories;

import org.springframework.data.repository.CrudRepository;
import pja.edu.pl.s30855.tpo12.auth.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

    boolean existsByName(String name);
}
