package pja.edu.pl.s30855.tpo_test_03.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pja.edu.pl.s30855.tpo_test_03.models.Course;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Long, Course> {
    Course findById(Long id);

    List<Course> getAll();

    void deleteById(Long id);
}
