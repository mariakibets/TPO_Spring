package pl.edu.pja.tpo03.tpo_lab_03.profiles;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.edu.pja.tpo03.tpo_lab_03.model.Entry;

@Service
@Profile("uppercase")
public class UpperCase implements Display{

    @Override
    public String format(Entry entry) {
        return entry.toString().toUpperCase();
    }
}
