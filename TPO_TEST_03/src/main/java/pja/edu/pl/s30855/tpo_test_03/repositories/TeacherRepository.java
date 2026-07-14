package pja.edu.pl.s30855.tpo_test_03.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pja.edu.pl.s30855.tpo_test_03.models.Teacher;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<Long, Teacher> {
    Teacher findById(Long id);

    List<Teacher> getAll();

    void deleteById(Long id);
}
