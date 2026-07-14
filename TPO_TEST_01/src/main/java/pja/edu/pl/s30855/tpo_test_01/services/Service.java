package pja.edu.pl.s30855.tpo_test_01.services;

import pja.edu.pl.s30855.tpo_test_01.entities.User;
import pja.edu.pl.s30855.tpo_test_01.repository.UserRepository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private final UserRepository repository;

    public Service (UserRepository repository){
        this.repository = repository;
    }

    public User getUserById(Long Id){
        User user = repository.findUserById(Id);
        return user;
    }

    public User getUserByName(String name){
        User user = repository.findUserByName(name);
        return user;
    }

    public User createUser(User user){
//       User user = new User (null, name, password, email);
       return repository.save(user);

    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

}
