package org.example.tpo_lecture_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpoLecture02Application {

    public static void main(String[] args) {

//        SpringApplication.run(TpoLecture02Application.class, args);
        MailProducer mailProducer = new MailProducer();
        ConsolePrinter consolePrinter = new ConsolePrinter(mailProducer);
        consolePrinter.printMessage();
    }

}
