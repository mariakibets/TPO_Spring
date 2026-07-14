package pl.edu.pja.tpo02.service;

import pl.edu.pja.tpo02.model.Entry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.edu.pja.tpo02.model.EntryRepository;

import java.io.*;

@Service
public class FileService {

    private final EntryRepository repository;

    @Value("${pl.edu.pja.tpo02.fileName}")
    private String fileName;


    public FileService(EntryRepository repository) {
        this.repository = repository;
    }

    public EntryRepository getRepository() {
        return repository;
    }

    public void loadEntries() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    repository.addEntries(new Entry(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void saveEntryToFile(Entry entry)throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(entry.getPolish() + "," + entry.getEnglish() + "," + entry.getGerman());
            bw.newLine();
        }
    }
}
