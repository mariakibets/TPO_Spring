package org.example.tpo_lecture_02;

public class ConsolePrinter {
    private MailProducer mailProducer;

    public ConsolePrinter(MailProducer mailProducer){
        this.mailProducer = mailProducer;
    }

    public String printMessage () {
        return "My mail NO.";
    }
}
