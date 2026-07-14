package pja.edu.pl.s30855.tpo12.repositories;

import org.springframework.data.repository.CrudRepository;
import pja.edu.pl.s30855.tpo12.auth.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);

    Optional<User> findById(Long userId);
}
