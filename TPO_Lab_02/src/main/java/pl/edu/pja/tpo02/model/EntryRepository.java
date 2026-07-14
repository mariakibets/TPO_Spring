package pl.edu.pja.tpo02.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntryRepository {

    private final List<Entry> entries = new ArrayList<>();

    public void addEntries(Entry entry) {
        entries.add(entry);
    }


    public List<Entry> showEntries() {
        return entries;
    }
}
