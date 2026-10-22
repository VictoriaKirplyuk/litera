package dev.victoria.litera.dto;

import java.util.List;

public record ResponseErrorDto(
        String status,
        String message,
        List<ResponseErrorFieldDto> fields
) {}
