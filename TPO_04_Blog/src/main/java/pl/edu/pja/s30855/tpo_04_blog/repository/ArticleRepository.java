package pl.edu.pja.s30855.tpo_04_blog.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pja.s30855.tpo_04_blog.entities.Article;
import pl.edu.pja.s30855.tpo_04_blog.entities.User;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Query("SELECT a FROM Article a")
    List<Article> listAllArticles();

    @Query("SELECT a FROM Article a WHERE a.title LIKE %?1%")
    List<Article> findArticlesByTitleContaining(String title);


    @Query("DELETE FROM Article a WHERE a.title = ?1")
    @Modifying
    @Transactional
    void removeArticleByTitle(String title);

    @Query("SELECT a FROM Article a WHERE a.author = ?1")
    List<Article> findByAuthor(User author);
}
