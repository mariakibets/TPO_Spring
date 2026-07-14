package pl.edu.pja.tpo03.tpo_lab_03_2.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.edu.pja.tpo03.tpo_lab_03_2.model.Entry;

@Service
@Profile("original")
public class Original implements Display{
    @Override
    public String format(Entry entry) {
        return entry.toString();
    }
}
