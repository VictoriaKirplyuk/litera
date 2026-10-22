package dev.victoria.litera.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestAuthorDto(
        @NotBlank
        @Size(max = 50, min = 2)
        String firstName,

        @Size(max = 50, min = 2)
        String middleName,

        @NotBlank
        @Size(max = 50, min = 2)
        String lastName
) {}
