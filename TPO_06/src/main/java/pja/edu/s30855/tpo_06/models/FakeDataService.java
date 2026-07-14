package pja.edu.s30855.tpo_06.models;

import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;


@Service
public class FakeDataService {
    public List<PersonDTO> generateFakePeople(int count, String language, Set<String> fields) {
        Faker faker = new Faker(new Locale(language));
        List<PersonDTO> people = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            PersonDTO person = new PersonDTO();
            person.setFirstName(faker.name().firstName());
            person.setLastName(faker.name().lastName());
            LocalDate birthday = faker.timeAndDate().birthday();
            person.setDateOfBirth(birthday);


            if (fields.contains("address")) person.setAddress(faker.address().fullAddress());
            if (fields.contains("university")) person.setUniversity(faker.university().name());
            if (fields.contains("countryOfOrigin")) person.setCountryOfOrigin(faker.country().name());
            if (fields.contains("jobTitle")) person.setJobTitle(faker.job().title());
            if (fields.contains("phoneNumber")) person.setPhoneNumber(faker.phoneNumber().cellPhone());
            if (fields.contains("email")) person.setEmail(faker.internet().emailAddress());
            if (fields.contains("hobby")) person.setHobby(faker.hobby().activity());
            if (fields.contains("company")) person.setCompany(faker.company().name());

            people.add(person);
        }
        return people;
    }
}
