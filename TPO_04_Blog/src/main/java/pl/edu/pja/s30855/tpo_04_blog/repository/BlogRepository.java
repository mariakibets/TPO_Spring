package pl.edu.pja.s30855.tpo_04_blog.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pja.s30855.tpo_04_blog.entities.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {
    @Query("SELECT b FROM Blog b")
    List<Blog> listAllBlogs();

    @Query("SELECT b FROM Blog b WHERE b.name = ?1")
    List<Blog> findBlogsByName(String name);


    @Query("DELETE FROM Blog b WHERE b.name = ?1")
    @Modifying
    @Transactional
    void removeBlogByName(String name);
}
