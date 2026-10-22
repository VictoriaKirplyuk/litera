package dev.victoria.litera.dto;

import java.time.Year;
import java.util.Set;

public record ResponseBookDto(
        Long id,
        String title,
        String ISBN,
        String languageCode,
        Year publishedAt,
        Integer ageLimit,
        Integer pageCount,
        Integer printRun,
        Set<ResponseAuthorDto> authors
) {}
