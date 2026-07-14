package pja.edu.pl.s30855.tpo_10.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pja.edu.pl.s30855.tpo_10.models.Link;

import java.util.Optional;

@Repository
public interface LinkRepository extends CrudRepository<Link, Integer> {
    Optional<Link> findById(String Id);

    Optional<Link> deleteLinkById(String Id);

    Optional<Link> getLinkByNameAndPassword(String name, String password);

    boolean existsLinkById(String Id);
}
