package pl.edu.pja.tpo03.tpo_lab_03.repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.edu.pja.tpo03.tpo_lab_03.model.Entry;

import java.util.List;

@Repository
@Transactional
public class EntryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Entry entry) {
        entityManager.persist(entry);
    }

    public List<Entry> findAll() {
        TypedQuery<Entry> query = entityManager.createQuery("SELECT e FROM Entry e", Entry.class);
        return query.getResultList();
    }

    public Entry findById(Long id) {
        return entityManager.find(Entry.class, id);
    }

    public void delete(Long id) {
        Entry entry = findById(id);
        if (entry != null) {
            entityManager.remove(entry);
        }
    }

    public void update(Entry entry) {
        entityManager.merge(entry);
    }

    public List<Entry> sortEntriesByLanguage(String language, boolean ascending) {
        String queryStr = "SELECT e FROM Entry e";

        switch (language.toLowerCase()) {
            case "english":
                queryStr += " ORDER BY e.english";
                break;
            case "german":
                queryStr += " ORDER BY e.german";
                break;
            case "polish":
                queryStr += " ORDER BY e.polish";
                break;
            default:
                throw new IllegalArgumentException("Invalid language: " + language);
        }

        if (!ascending) {
            queryStr += " DESC";
        }

        TypedQuery<Entry> query = entityManager.createQuery(queryStr, Entry.class);
        return query.getResultList();
    }


    public List<Entry> search(String word) {
        TypedQuery<Entry> query = entityManager.createQuery("SELECT e FROM Entry e WHERE e.polish LIKE :word OR e.english LIKE :word OR e.german LIKE :word", Entry.class);
        query.setParameter("word", "%" + word + "%");
        return query.getResultList();
    }

}
