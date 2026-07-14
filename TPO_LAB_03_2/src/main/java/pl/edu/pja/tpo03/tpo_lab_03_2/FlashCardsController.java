package pl.edu.pja.tpo03.tpo_lab_03_2;

import org.springframework.stereotype.Controller;
import pl.edu.pja.tpo03.tpo_lab_03_2.model.Entry;
import pl.edu.pja.tpo03.tpo_lab_03_2.profiles.Display;
import pl.edu.pja.tpo03.tpo_lab_03_2.service.EntryService;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Controller
public class FlashCardsController {

    private final EntryService entryService;

    private final Display display;

    private Scanner scanner = new Scanner(System.in);

    public FlashCardsController(EntryService entryService, Display display){
        this.entryService = entryService;
        this.display = display;
    }

    public void run() {
        while (true) {
            System.out.println("Add word: 1 | Show words: 2 | Sort words: 3 | Search: 4 | Delete a word: 5 | Modify a word: 6 | Test yourself: 7 | Exit: 8");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addWord();
                case "2" -> showWords();
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

    public void addWord() {
        System.out.println("Enter the id first: ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter Polish word: ");
        String polish = scanner.nextLine();
        System.out.println("Enter English word: ");
        String english = scanner.nextLine();
        System.out.println("Enter German word: ");
        String german = scanner.nextLine();

        Entry entry = new Entry(polish, english, german, id);
        entryService.saveEntry(entry);
    }

    public void showWords() {
        List<Entry> entries = entryService.getAllEntries();
        entries.forEach(entry -> System.out.println(display.format(entry)));
    }

    public void sortWords() {
        System.out.println("Enter language (polish, english, german): ");
        String language = scanner.nextLine();
        System.out.println("Enter sort order (asc/desc): ");
        String order = scanner.nextLine();

        List<Entry> sortedEntries = entryService.getSortedEntries(language, order.equalsIgnoreCase("asc"));
        sortedEntries.forEach(entry -> System.out.println(display.format(entry)));
    }

    public void searchWord() {
        System.out.println("Choose a language: ");
        String language = scanner.nextLine();
        System.out.println("Enter word to search: ");
        String word = scanner.nextLine();

        List<Entry> foundEntries = entryService.searchEntries(word, language);
        foundEntries.forEach(entry -> System.out.println(display.format(entry)));
    }

    public void deleteWord() {
        System.out.println("Enter word ID to delete: ");
        Long id = Long.parseLong(scanner.nextLine());
        entryService.deleteEntry(id);
    }

    public void modifyWord() {
        System.out.println("Enter word ID to modify: ");
        Long id = Long.parseLong(scanner.nextLine());
        Entry entry = entryService.getAllEntries().stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        if (entry != null) {
            System.out.println("Enter new Polish word: ");
            entry.setPolish(scanner.nextLine());
            System.out.println("Enter new English word: ");
            entry.setEnglish(scanner.nextLine());
            System.out.println("Enter new German word: ");
            entry.setGerman(scanner.nextLine());
            entryService.saveEntry(entry);
        }
    }

    public void test() {
        List<Entry> entries = entryService.getAllEntries();
        if (entries.isEmpty()) {
            System.out.println("The repository is empty. No words available.");
            return;
        }

        Random random = new Random();
        Entry entry = entries.get(random.nextInt(entries.size()));

        System.out.println("Translate: " + entry.getPolish());
        System.out.print("English: ");
        String english = scanner.nextLine();
        System.out.print("German: ");
        String german = scanner.nextLine();

        if (entry.getEnglish().equalsIgnoreCase(english) && entry.getGerman().equalsIgnoreCase(german)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong! Correct: " + display.format(entry));
        }
    }
}
