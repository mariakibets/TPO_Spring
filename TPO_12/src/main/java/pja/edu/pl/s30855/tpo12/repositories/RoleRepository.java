package pja.edu.pl.s30855.tpo12.repositories;

import org.springframework.data.repository.CrudRepository;
import pja.edu.pl.s30855.tpo12.auth.Role;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
