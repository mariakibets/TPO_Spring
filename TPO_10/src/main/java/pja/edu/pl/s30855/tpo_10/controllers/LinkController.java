package pja.edu.pl.s30855.tpo_10.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pja.edu.pl.s30855.tpo_10.models.LinkRequest;
import pja.edu.pl.s30855.tpo_10.models.LinkResponse;
import pja.edu.pl.s30855.tpo_10.services.LinkService;
import java.net.URI;


@RestController
@RequestMapping(path="/api",
        produces = {MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE})
public class LinkController {

    private final LinkService service;

    public LinkController(LinkService service){
        this.service = service;
    }

    @Tag(name = "POST", description = "create a new link")
    @PostMapping("/links")
    public ResponseEntity<LinkResponse> createLink(@RequestBody LinkRequest request) {
        LinkResponse response = service.createLink(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(response);
    }

    @Tag(name = "GET", description = "get a link by Id")
    @GetMapping("/links/{id}")
    public ResponseEntity<LinkResponse> getLink(@PathVariable String id) {
        return ResponseEntity
                .ok(service.getLinkById(id));
    }

    @Tag(name = "GET", description = "get a REDIRECT link by Id")
    @GetMapping("/red/{id}")
    public ResponseEntity<Void> redirect(@PathVariable String id) {
        String targetUrl = service.redirectToTarget(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(targetUrl.trim()))
                .build();
    }

    @Tag(name = "PATCH", description = "update a link by Id")
    @PatchMapping("/links/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody LinkRequest request) {
        service.updateLink(id, request);
        return ResponseEntity.noContent().build();
    }


    @Tag(name = "DELETE", description = "delete a link by Id")
    @DeleteMapping("/links/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id, @RequestParam(required = false) String pass) {
        service.deleteLink(id, pass);
        return ResponseEntity.noContent().build();
    }
}
