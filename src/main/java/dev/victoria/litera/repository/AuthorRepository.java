package dev.victoria.litera.repository;

import dev.victoria.litera.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Boolean existsAuthorEntityByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
}
