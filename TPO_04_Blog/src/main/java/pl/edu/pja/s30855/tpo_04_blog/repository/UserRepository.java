package pl.edu.pja.s30855.tpo_04_blog.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pja.s30855.tpo_04_blog.entities.User;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u")
    List<User> listAllUsers();

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    List<User> findUserByEmail(String email);


    @Query("DELETE FROM User u WHERE u.email = ?1")
    @Modifying
    @Transactional
    void removeUserByEmail(String email);
}
