package com.devteria.data_encryption_demo.converter;

import jakarta.persistence.AttributeConverter;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

public class EncryptConverter implements AttributeConverter<String, String> {

    //Convert data into database
    //Encrypt data
    @Override
    public String convertToDatabaseColumn(String data) {
        if(Objects.isNull(data)){
            return null;
        }
        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    //Convert data into entity
    //Decrypt
    @Override
    public String convertToEntityAttribute(String value) {
        if(Objects.isNull(value)){
            return null;
        }
        return new String(Base64.getDecoder().decode(value), StandardCharsets.UTF_8);
    }
}
