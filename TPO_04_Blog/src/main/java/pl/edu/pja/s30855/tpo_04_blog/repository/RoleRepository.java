package pl.edu.pja.s30855.tpo_04_blog.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pja.s30855.tpo_04_blog.entities.Role;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    @Query("SELECT r FROM Role r")
    List<Role> listAllRoles();

    @Query("SELECT r FROM Role r WHERE r.name = :name")
    List<Role> findRoleByName(String name);


    @Modifying
    @Transactional
    @Query("DELETE FROM Role r WHERE r.name = :name")
    void removeRoleByName(String name);
}
