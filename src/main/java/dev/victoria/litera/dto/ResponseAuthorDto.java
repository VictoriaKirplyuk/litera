package dev.victoria.litera.dto;

public record ResponseAuthorDto (
        Long id,
        String firstName,
        String middleName,
        String lastName
) {}

// /api/authors/1
// /api/authors/{id}/books