package pl.edu.pja.tpo03.tpo_lab_03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlashCardsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FlashCardsApplication.class, args);
        FlashCardsController controller = context.getBean(FlashCardsController.class);
        controller.run();
    }

}
