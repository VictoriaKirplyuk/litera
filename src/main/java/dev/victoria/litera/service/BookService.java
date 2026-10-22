package dev.victoria.litera.service;

import dev.victoria.litera.dto.RequestBookDto;
import dev.victoria.litera.dto.ResponseBookDto;
import dev.victoria.litera.entity.AuthorEntity;
import dev.victoria.litera.entity.BookEntity;
import dev.victoria.litera.mapper.BookMapper;
import dev.victoria.litera.repository.AuthorRepository;
import dev.victoria.litera.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final BookMapper mapper;

    @Autowired
    public BookService(
            BookRepository repository,
            AuthorRepository authorRepository,
            BookMapper mapper
            ) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    public ResponseBookDto createBook(RequestBookDto request) {
        List<AuthorEntity> authors = authorRepository.findAllById(request.authorIds());

        if (authors.isEmpty()) throw new EntityNotFoundException("Authors with such IDs don't exist");

        BookEntity newBook = new BookEntity(
                request.title(),
                request.ISBN(),
                request.languageCode(),
                request.publishedAt(),
                request.ageLimit(),
                request.pageCount(),
                request.printRun()
        );
        newBook.setAuthors(new HashSet<>(authors));
        BookEntity createdBook = repository.save(newBook);

        return mapper.toResponseDto(createdBook);
    }
}

// 1 Controller - DTO -> Model
// 2 Service - Model <-> Entity
// 3 Repository - Entity