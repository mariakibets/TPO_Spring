package pja.edu.pl.s30855.tpo_10.services;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pja.edu.pl.s30855.tpo_10.IdGenerator;
import pja.edu.pl.s30855.tpo_10.models.Link;
import pja.edu.pl.s30855.tpo_10.models.LinkRequest;
import pja.edu.pl.s30855.tpo_10.models.LinkResponse;
import pja.edu.pl.s30855.tpo_10.repositories.LinkRepository;



import java.util.Optional;
import java.util.Set;

@Service
public class LinkService {

    public final LinkRepository repository;

    private final Validator validator;

    public LinkService(LinkRepository linkRepository, Validator validator){
        this.repository = linkRepository;
        this.validator = validator;
    }


    public LinkResponse createLink(LinkRequest request) {
        Set<ConstraintViolation<LinkRequest>> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            System.out.println("Cannot add Link object! Errors:");
            errors.forEach(err -> System.out.println(
                    "> " + err.getPropertyPath() + " " + err.getMessage() + " (" + err.getInvalidValue() + ")"
            ));
        }
        String id = IdGenerator.generateId();
        while (repository.existsLinkById(id)) {
            id = IdGenerator.generateId();
        }

        Link link = new Link();
        link.setId(id);
        link.setName(request.getName());
        link.setTargetUrl(request.getTargetUrl());
        link.setPassword(request.getPassword());
        link.setVisits(0);

        repository.save(link);
        return toResponse(link);
    }

    public LinkResponse getLinkById(String id) {
        Link link = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return toResponse(link);
    }


    public String redirectToTarget(String id) {
        Link link = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        System.out.println("Redirecting to: " + link.getTargetUrl());
        link.incrementVisits();
        repository.save(link);
        return link.getTargetUrl();
    }


    public void updateLink(String id, LinkRequest request) {

        Set<ConstraintViolation<LinkRequest>> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            System.out.println("Cannot update Link object! Errors:");
            errors.forEach(err -> System.out.println(
                    "> " + err.getPropertyPath() + " " + err.getMessage() + " (" + err.getInvalidValue() + ")"
            ));
        }

        Link link = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (link.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "link is not password-protected");
        }

        if (request.getPassword() == null || !link.getPassword().equals(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "wrong password");
        }

        if (request.getName() != null) {
            link.setName(request.getName());
        }

        if (request.getTargetUrl() != null) {
            link.setTargetUrl(request.getTargetUrl());
        }

        repository.save(link);
    }

    public void deleteLink(String id, String password) {
        Optional<Link> opt = repository.findById(id);
        if (opt.isEmpty()) {
            return;
        }

        Link link = opt.get();

        System.out.println("Stored password: " + link.getPassword());
        System.out.println("Provided password: " + password);


        if (link.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "link is not password-protected");
        }

        if (password == null || !link.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "wrong password");
        }

        repository.delete(link);
    }

    public LinkResponse getLinkByNameAndPassword(String name, String password){
        return repository.getLinkByNameAndPassword(name, password)
                .map(this::toResponse)
                .orElse(null);
    }

    public Link getLinkEntityById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    private LinkResponse toResponse(Link link) {
        return new LinkResponse(
                link.getId(),
                link.getName(),
                link.getTargetUrl(),
                "http://localhost:8080/red/" + link.getId(),
                link.getVisits()
        );
    }


}
