package dev.victoria.litera.mapper;

import dev.victoria.litera.dto.ResponseAuthorDto;
import dev.victoria.litera.dto.ResponseBookDto;
import dev.victoria.litera.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public ResponseBookDto toResponseDto(BookEntity entity) {
        Set<ResponseAuthorDto> authors = entity.getAuthors().stream()
                .map(e -> new ResponseAuthorDto(
                        e.getId(),
                        e.getFirstName(),
                        e.getMiddleName(),
                        e.getLastName()
                )).collect(Collectors.toSet());

        return new ResponseBookDto(
                entity.getId(),
                entity.getTitle(),
                entity.getISBN(),
                entity.getLanguageCode(),
                entity.getPublishedAt(),
                entity.getAgeLimit(),
                entity.getPageCount(),
                entity.getPrintRun(),
                authors
        );
    }
}
