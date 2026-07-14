package pl.edu.pja.tpo03.tpo_lab_03_2.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.tpo03.tpo_lab_03_2.model.Entry;
import pl.edu.pja.tpo03.tpo_lab_03_2.repository.EntryRepository;

import java.util.List;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public void saveEntry(Entry entry) {
        entryRepository.save(entry);
    }

    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    public List<Entry> searchEntries(String searchTerm, String language) {
        if("english".equalsIgnoreCase(language)){
            return entryRepository.findByEnglish(searchTerm);
        } else if ("german".equalsIgnoreCase(language)) {
            return entryRepository.findByGerman(searchTerm);
        } else if ("polish".equalsIgnoreCase(language)) {
            return entryRepository.findByPolish(searchTerm);
        }
        return entryRepository.findAll();
    }

    public List<Entry> getSortedEntries(String language, boolean ascending) {
        if ("english".equalsIgnoreCase(language)) {
            return ascending ? entryRepository.findAllByOrderByEnglishAsc() : entryRepository.findAllByOrderByEnglishDesc();
        } else if ("german".equalsIgnoreCase(language)) {
            return ascending ? entryRepository.findAllByOrderByGermanAsc() : entryRepository.findAllByOrderByGermanDesc();
        } else if ("polish".equalsIgnoreCase(language)) {
            return ascending ? entryRepository.findAllByOrderByPolishAsc() : entryRepository.findAllByOrderByPolishDesc();
        }
        return entryRepository.findAll();
    }

    public void deleteEntry(Long id) {
        entryRepository.deleteById(id);
    }

}
