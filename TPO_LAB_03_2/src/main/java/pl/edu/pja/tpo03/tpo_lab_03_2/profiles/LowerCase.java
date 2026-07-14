package pl.edu.pja.tpo03.tpo_lab_03_2.profiles;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.edu.pja.tpo03.tpo_lab_03_2.model.Entry;

@Service
@Profile("lowercase")
public class LowerCase implements Display {
    @Override
    public String format(Entry entry) {
        return entry.toString().toLowerCase();
    }
}
