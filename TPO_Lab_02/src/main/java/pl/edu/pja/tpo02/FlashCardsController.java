package pl.edu.pja.tpo02;

import pl.edu.pja.tpo02.model.Entry;
import pl.edu.pja.tpo02.profiles.Display;
import pl.edu.pja.tpo02.service.FileService;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

@Controller
public class FlashCardsController {

    private final Display display;

    private final FileService fileService;

    private Scanner scanner = new Scanner(System.in);

    public FlashCardsController(Display display, FileService fileService){
        this.display = display;
        this.fileService = fileService;
    }

    public void run(){
        fileService.loadEntries();
        while(true){
            System.out.println(" Add word: 1  |  Show words: 2  | Sort words: 3 | Search a word: 4 | Delete a word: 5 | Modify a word: 6|  Test: 7 |  Exit: 8 ");
            String choice = scanner.nextLine();

            switch (choice){
                case "1" -> addWord();
                case "2" -> showList();
                case "3" -> sortWords();
                case "4" -> searchWord();
                case "5" -> deleteWord();
                case "6" -> modifyWord();
                case "7" -> test();
                case "8" -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }
    }


    public void addWord(){
        System.out.println("Enter a polish word: ");
        String polish = scanner.nextLine();
        System.out.println("Enter english translation: ");
        String english = scanner.nextLine();
        System.out.println("Enter german translation: ");
        String german = scanner.nextLine();

        Entry entry = new Entry(polish, english, german);
        fileService.getRepository().addEntries(entry);
        try {
            fileService.saveEntryToFile(entry);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }


    public void showList(){
       fileService.getRepository().showEntries().forEach(entry ->
                System.out.println(display.format(entry)));
    }

    public void test(){
        if(fileService.getRepository().showEntries().isEmpty()){
            System.out.println("The repository us empty. No words available");
        }

        Random random = new Random();
        Entry entry = fileService.getRepository().showEntries().get(random.nextInt(fileService.getRepository().showEntries().size()));

        System.out.println("Translate: " + entry.getPolish());
        System.out.println("English: ");
        String english = scanner.nextLine();
        System.out.println("German: ");
        String german = scanner.nextLine();

        if(entry.getEnglish().equalsIgnoreCase(english) && entry.getGerman().equalsIgnoreCase(german)){
            System.out.println("Correct!");
        }else {
            System.out.println("Wrong! Correct: " +display.format(entry));
        }
    }

    public void sortWords(){

    }

    public void deleteWord(){}

    public void searchWord(){
        System.out.println("Enter the word: ");
        String word = scanner.nextLine();
        
    }

    public void modifyWord(){}
}
