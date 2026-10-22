package dev.victoria.litera.dto;

import jakarta.validation.constraints.*;

import java.time.Year;
import java.util.Set;

public record RequestBookDto(

        @NotBlank
        @Size(max = 200)
        String title,

        @NotBlank
        @Pattern(
                regexp = "^(?=(?:[^0-9]*[0-9]){10}(?:(?:[^0-9]*[0-9]){3})?$)[\\d-]+$",
                message = "ISBN doesn't match with pattern"
        )
        String ISBN,

        @NotBlank
        @Pattern(
                regexp = "^[a-z]{2}(-[A-Z]{2})?$",
                message = "Language code doesn't match with pattern"
        )
        String languageCode,

        @NotNull
        @PastOrPresent
        Year publishedAt,

        @Positive
        @Max(18)
        Integer ageLimit,

        @Positive
        @Max(10_000)
        Integer pageCount,

        @Positive
        @Max(10_000_000)
        Integer printRun,

        Set<Long> authorIds
) {}
