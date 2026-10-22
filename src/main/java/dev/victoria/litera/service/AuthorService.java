package dev.victoria.litera.service;

import dev.victoria.litera.dto.RequestAuthorDto;
import dev.victoria.litera.dto.ResponseAuthorDto;
import dev.victoria.litera.entity.AuthorEntity;
import dev.victoria.litera.mapper.AuthorMapper;
import dev.victoria.litera.repository.AuthorRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Autowired
    public AuthorService(AuthorRepository repository, AuthorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ResponseAuthorDto createAuthor(RequestAuthorDto request) {
        if (repository.existsAuthorEntityByFirstNameAndMiddleNameAndLastName(
                request.firstName(),
                request.middleName(),
                request.lastName()
        )) throw new EntityExistsException("This author exists");

        AuthorEntity newAuthor = new AuthorEntity(
                request.firstName(),
                request.middleName(),
                request.lastName()
        );

        AuthorEntity createdAuthor = repository.save(newAuthor);

        return mapper.toResponseDto(createdAuthor);
    }
}
