package com.devteria.data_encryption_demo.converter;

import jakarta.persistence.AttributeConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

public class BCryptConverter implements AttributeConverter<String, String> {
    private final BCryptPasswordEncoder bCryptPasswordEncoder =
            new BCryptPasswordEncoder(12);

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }

        return bCryptPasswordEncoder.encode(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }

        return dbData;
    }
}
