package pl.edu.pja.tpo03.tpo_lab_03.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.edu.pja.tpo03.tpo_lab_03.repository.EntryRepository;
import pl.edu.pja.tpo03.tpo_lab_03.model.Entry;

import java.util.List;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @Transactional
    public void addEntry(Entry entry) {
        entryRepository.add(entry);
    }

    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    @Transactional
    public void deleteEntry(Long id) {
        entryRepository.delete(id);
    }

    @Transactional
    public void updateEntry(Entry entry) {
        entryRepository.update(entry);
    }

    public List<Entry> sortEntriesByLanguage(String language, boolean ascending) {
        if (!language.equals("english") && !language.equals("german") && !language.equals("polish")) {
            throw new IllegalArgumentException("Invalid language: " + language);
        }

        return entryRepository.sortEntriesByLanguage(language, ascending);
    }


    public List<Entry> searchEntries(String word) {
        return entryRepository.search(word);
    }
}
