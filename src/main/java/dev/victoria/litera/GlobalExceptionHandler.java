package dev.victoria.litera;

import dev.victoria.litera.dto.ResponseErrorDto;
import dev.victoria.litera.dto.ResponseErrorFieldDto;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ResponseErrorDto> handleEntityExistsException(EntityExistsException exception) {
        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
              HttpStatus.CONFLICT.getReasonPhrase(),
                exception.getMessage(),
                List.of()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseErrorDto);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseErrorDto> handleEntityNotFoundException(EntityNotFoundException exception) {
        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                List.of()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseErrorDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDto> handleValidationException(MethodArgumentNotValidException exception) {
        List<ResponseErrorFieldDto> fields = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new ResponseErrorFieldDto(error.getField(), error.getDefaultMessage()))
                .toList();

        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation failed",
                fields
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseErrorDto);
    }
}
