package dev.victoria.litera.mapper;

import dev.victoria.litera.dto.ResponseAuthorDto;
import dev.victoria.litera.entity.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public ResponseAuthorDto toResponseDto (AuthorEntity entity) {
        return new ResponseAuthorDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getMiddleName(),
                entity.getLastName()
        );
    }
}
