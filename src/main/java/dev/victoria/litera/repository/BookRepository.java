package dev.victoria.litera.repository;

import dev.victoria.litera.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Boolean existsByISBN(String ISBN);
}
