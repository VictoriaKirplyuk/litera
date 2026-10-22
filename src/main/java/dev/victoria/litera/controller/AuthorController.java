package dev.victoria.litera.controller;

import dev.victoria.litera.dto.RequestAuthorDto;
import dev.victoria.litera.dto.ResponseAuthorDto;
import dev.victoria.litera.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService service;

    @Autowired
    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ResponseAuthorDto> createAuthor(
           @Valid @RequestBody RequestAuthorDto request
    ) {
        ResponseAuthorDto authorDto = service.createAuthor(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(authorDto);
    }
}
