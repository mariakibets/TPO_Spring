package pja.edu.pl.s30855.tpo12.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pja.edu.pl.s30855.tpo12.auth.*;
import pja.edu.pl.s30855.tpo12.repositories.PublisherRepository;
import pja.edu.pl.s30855.tpo12.repositories.RoleRepository;
import pja.edu.pl.s30855.tpo12.repositories.UserRepository;

import java.util.Collections;

@Service
public class UserService {

    private final PublisherRepository publisherRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(PublisherRepository publisherRepository,
                       UserRepository userRepository,
                       RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.publisherRepository = publisherRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerPublisher(PublisherRegistrationDTO dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }

        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role publisherRole = roleRepository.findByName("PUBLISHER")
                .orElseThrow(() -> new RuntimeException("Role PUBLISHER not found"));
        user.setRoles(Collections.singleton(publisherRole));

        userRepository.save(user);

        Publisher publisher = new Publisher();
        publisher.setName(dto.getPublisherName());

        publisherRepository.save(publisher);
    }


    public User registerReader(ReaderRegistrationDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role role = roleRepository.findByName("READER")
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.getRoles().add(role);

        return userRepository.save(user);
    }


}
