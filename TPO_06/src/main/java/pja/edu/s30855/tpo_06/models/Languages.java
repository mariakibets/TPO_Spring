package pja.edu.s30855.tpo_06.models;


import java.util.HashMap;
import java.util.Map;

public class Languages {

    public static Map<String, String> getFieldLabels(String language) {
        Map<String, String> labels = new HashMap<>();

        switch (language) {
            case "pl":
                labels.put("firstName", "Imię");
                labels.put("lastName", "Nazwisko");
                labels.put("dateOfBirth", "Data urodzenia");
                labels.put("address", "Adres");
                labels.put("university", "Uniwersytet");
                labels.put("countryOfOrigin", "Kraj pochodzenia");
                labels.put("jobTitle", "Zawód");
                labels.put("phoneNumber", "Telefon");
                labels.put("email", "Email");
                labels.put("hobby", "Hobby");
                labels.put("company", "Firma");
                break;
            case "fr":
                labels.put("firstName", "Prénom");
                labels.put("lastName", "Nom de famille");
                labels.put("dateOfBirth", "Date de naissance");
                labels.put("address", "Adresse");
                labels.put("university", "Université");
                labels.put("countryOfOrigin", "Pays d'origine");
                labels.put("jobTitle", "Profession");
                labels.put("phoneNumber", "Téléphone");
                labels.put("email", "Email");
                labels.put("hobby", "Passe-temps");
                labels.put("company", "Entreprise");
                break;
            case "de":
                labels.put("firstName", "Vorname");
                labels.put("lastName", "Nachname");
                labels.put("dateOfBirth", "Geburtsdatum");
                labels.put("address", "Adresse");
                labels.put("university", "Universität");
                labels.put("countryOfOrigin", "Herkunftsland");
                labels.put("jobTitle", "Beruf");
                labels.put("phoneNumber", "Telefon");
                labels.put("email", "E-Mail");
                labels.put("hobby", "Hobby");
                labels.put("company", "Firma");
                break;
            case "es":
                labels.put("firstName", "Nombre");
                labels.put("lastName", "Apellido");
                labels.put("dateOfBirth", "Fecha de nacimiento");
                labels.put("address", "Dirección");
                labels.put("university", "Universidad");
                labels.put("countryOfOrigin", "País de origen");
                labels.put("jobTitle", "Ocupación");
                labels.put("phoneNumber", "Teléfono");
                labels.put("email", "Correo electrónico");
                labels.put("hobby", "Pasatiempo");
                labels.put("company", "Empresa");
                break;
            case "it":
                labels.put("firstName", "Nome");
                labels.put("lastName", "Cognome");
                labels.put("dateOfBirth", "Data di nascita");
                labels.put("address", "Indirizzo");
                labels.put("university", "Università");
                labels.put("countryOfOrigin", "Paese d'origine");
                labels.put("jobTitle", "Professione");
                labels.put("phoneNumber", "Telefono");
                labels.put("email", "Email");
                labels.put("hobby", "Hobby");
                labels.put("company", "Azienda");
                break;
            case "pt":
                labels.put("firstName", "Nome");
                labels.put("lastName", "Sobrenome");
                labels.put("dateOfBirth", "Data de nascimento");
                labels.put("address", "Endereço");
                labels.put("university", "Universidade");
                labels.put("countryOfOrigin", "País de origem");
                labels.put("jobTitle", "Profissão");
                labels.put("phoneNumber", "Telefone");
                labels.put("email", "Email");
                labels.put("hobby", "Passatempo");
                labels.put("company", "Empresa");
                break;
            case "nl":
                labels.put("firstName", "Voornaam");
                labels.put("lastName", "Achternaam");
                labels.put("dateOfBirth", "Geboortedatum");
                labels.put("address", "Adres");
                labels.put("university", "Universiteit");
                labels.put("countryOfOrigin", "Land van herkomst");
                labels.put("jobTitle", "Beroep");
                labels.put("phoneNumber", "Telefoonnummer");
                labels.put("email", "E-mail");
                labels.put("hobby", "Hobby");
                labels.put("company", "Bedrijf");
                break;
            case "uk":
                labels.put("firstName", "Ім'я");
                labels.put("lastName", "Прізвище");
                labels.put("dateOfBirth", "Дата народження");
                labels.put("address", "Адреса");
                labels.put("university", "Університет");
                labels.put("countryOfOrigin", "Країна походження");
                labels.put("jobTitle", "Професія");
                labels.put("phoneNumber", "Телефон");
                labels.put("email", "Електронна пошта");
                labels.put("hobby", "Хобі");
                labels.put("company", "Компанія");
                break;
            case "ru":
                labels.put("firstName", "Имя");
                labels.put("lastName", "Фамилия");
                labels.put("dateOfBirth", "Дата рождения");
                labels.put("address", "Адрес");
                labels.put("university", "Университет");
                labels.put("countryOfOrigin", "Страна происхождения");
                labels.put("jobTitle", "Профессия");
                labels.put("phoneNumber", "Телефон");
                labels.put("email", "Электронная почта");
                labels.put("hobby", "Хобби");
                labels.put("company", "Компания");
                break;
            default:
                labels.put("firstName", "First Name");
                labels.put("lastName", "Last Name");
                labels.put("dateOfBirth", "Date of Birth");
                labels.put("address", "Address");
                labels.put("university", "University");
                labels.put("countryOfOrigin", "Country of Origin");
                labels.put("jobTitle", "Job Title");
                labels.put("phoneNumber", "Phone");
                labels.put("email", "Email");
                labels.put("hobby", "Hobby");
                labels.put("company", "Company");
                break;
        }

        return labels;
    }

}
