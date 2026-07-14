package pja.edu.pl.s30855.tpo_test_01.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pja.edu.pl.s30855.tpo_test_01.entities.User;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(Long Id);

    User findUserByName(String name);

    List<User> findAll();

}
