package dev.victoria.litera.controller;

import dev.victoria.litera.dto.RequestBookDto;
import dev.victoria.litera.dto.ResponseBookDto;
import dev.victoria.litera.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResponseBookDto> createBook(
            @Valid @RequestBody RequestBookDto request
    ) {
        ResponseBookDto bookDto = service.createBook(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }
}
