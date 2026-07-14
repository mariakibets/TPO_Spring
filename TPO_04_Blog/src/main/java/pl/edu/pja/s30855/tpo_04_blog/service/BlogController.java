package pl.edu.pja.s30855.tpo_04_blog.service;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pja.s30855.tpo_04_blog.entities.Article;
import pl.edu.pja.s30855.tpo_04_blog.entities.Blog;
import pl.edu.pja.s30855.tpo_04_blog.entities.Role;
import pl.edu.pja.s30855.tpo_04_blog.entities.User;
import pl.edu.pja.s30855.tpo_04_blog.repository.ArticleRepository;
import pl.edu.pja.s30855.tpo_04_blog.repository.BlogRepository;
import pl.edu.pja.s30855.tpo_04_blog.repository.RoleRepository;
import pl.edu.pja.s30855.tpo_04_blog.repository.UserRepository;

import java.util.List;

@Controller
public class BlogController {

    private ArticleRepository articleRepository;

    private BlogRepository blogRepository;

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public BlogController(ArticleRepository articleRepository, BlogRepository blogRepository, UserRepository userRepository, RoleRepository roleRepository){
        this.articleRepository = articleRepository;
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void run() {
        User user1 = new User("bbb@example.com");
        User user2 = new User("oooo@example.com");

        System.out.println("All Users:");
        userRepository.listAllUsers().forEach(System.out::println);
        userRepository.save(user1);
        userRepository.save(user2);

        List<User> foundUsers = userRepository.findUserByEmail("bbb@example.com");
        if (!foundUsers.isEmpty()) {
            foundUsers.forEach(System.out::println);
        } else {
            System.out.println("No user found.");
        }

        userRepository.removeUserByEmail("oooo@example.com");

        Blog blog1 = new Blog("blabla", user2);
        System.out.println("All Blogs:");
        blogRepository.listAllBlogs().forEach(System.out::println);
        blogRepository.save(blog1);

        List<Blog> foundBlogs = blogRepository.findBlogsByName("ooo");
        if (!foundBlogs.isEmpty()) {
            foundBlogs.forEach(System.out::println);
        } else {
            System.out.println("No blogs found.");
        }

        blogRepository.removeBlogByName("bbb");

        Article article1 = new Article("bob", user2, blog1);
        System.out.println("All Articles:");
        articleRepository.listAllArticles().forEach(System.out::println);
        articleRepository.save(article1);

        List<Article> foundArticles = articleRepository.findArticlesByTitleContaining("bob");
        if (!foundArticles.isEmpty()) {
            foundArticles.forEach(System.out::println);
        } else {
            System.out.println("No articles found.");
        }

        articleRepository.removeArticleByTitle("bob");


        Role role1 = new Role("sss");
        System.out.println("All Roles:");
        roleRepository.listAllRoles().forEach(System.out::println);
        roleRepository.save(role1);

        List<Role> foundRoles = roleRepository.findRoleByName("bbb");
        if (!foundRoles.isEmpty()) {
            foundRoles.forEach(System.out::println);
        } else {
            System.out.println("No roles found.");
        }

        roleRepository.removeRoleByName("sss");

    }
}
