package pl.edu.pja.tpo03.tpo_lab_03_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pja.tpo03.tpo_lab_03_2.model.Entry;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByEnglish(String english);
    List<Entry> findByGerman(String german);
    List<Entry> findByPolish(String polish);
    List<Entry> findAllByOrderByEnglishAsc();
    List<Entry> findAllByOrderByGermanAsc();
    List<Entry> findAllByOrderByPolishAsc();
    List<Entry> findAllByOrderByEnglishDesc();
    List<Entry> findAllByOrderByGermanDesc();
    List<Entry> findAllByOrderByPolishDesc();
}
