package dev.victoria.litera.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import net.creativecouple.validation.isbn.ISBN;

@Converter
public class BookIsbnConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String attribute) {
        ISBN isbn = ISBN.valueOf(attribute);

        return isbn.toCompactString();
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        ISBN isbn = ISBN.valueOf(dbData);

        return isbn.toString();
    }
}
