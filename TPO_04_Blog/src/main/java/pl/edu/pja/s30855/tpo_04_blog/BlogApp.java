package pl.edu.pja.s30855.tpo_04_blog;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pl.edu.pja.s30855.tpo_04_blog.service.BlogController;

@SpringBootApplication
public class BlogApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BlogApp.class, args);
        BlogController controller = context.getBean(BlogController.class);
        controller.run();
    }

}
