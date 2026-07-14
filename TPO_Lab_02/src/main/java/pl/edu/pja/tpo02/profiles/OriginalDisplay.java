package pl.edu.pja.tpo02.profiles;


import pl.edu.pja.tpo02.model.Entry;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("original")
public class OriginalDisplay implements Display {

    @Override
    public String format(Entry entry) {
        return entry.toString();
    }
}
