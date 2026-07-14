package pja.edu.pl.s30855.tpo_07.models;

import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class StoredCodeRepository {

    private final String STORAGE_FOLDER = "storage";

    public StoredCodeRepository(){
        File folder = new File(STORAGE_FOLDER);
        if(!folder.exists()){
            folder.mkdir();
        }
    }
    
    public void save(StoredCode code) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(getFilePath(code.getId()))
        )) {
            out.writeObject(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cleanUp(){
        File folder = new File(STORAGE_FOLDER);
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                StoredCode code = (StoredCode) in.readObject();
                if (code.getExpiresAt().isBefore(LocalDateTime.now())) {
                    file.delete();
                }
            } catch (IOException | ClassNotFoundException e) {
                file.delete();
            }
        }
    }

    public List<StoredCode> find (String id){
        File file = new File(getFilePath(id));
        if (!file.exists()) return List.of();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            StoredCode code = (StoredCode) in.readObject();
            if (code.getExpiresAt().isAfter(LocalDateTime.now())) {
                return List.of(code);
            } else {
                file.delete();
                return List.of();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    private String getFilePath(String id) {
        return STORAGE_FOLDER + File.separator + id + ".ser";
    }

}
