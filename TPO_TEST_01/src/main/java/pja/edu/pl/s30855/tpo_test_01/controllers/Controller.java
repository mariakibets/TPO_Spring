package pja.edu.pl.s30855.tpo_test_01.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pja.edu.pl.s30855.tpo_test_01.entities.User;
import pja.edu.pl.s30855.tpo_test_01.services.Service;

import java.util.List;

@RestController
@RequestMapping("/users")
public class Controller {

    private final Service service;

    public Controller(Service service){
        this.service = service;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = service.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<User> getUserByName(@PathVariable String name){
        User user = service.getUserByName(name);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public User createUser(
           @RequestBody User user
    ){
        return service.createUser(user);
    }
}
