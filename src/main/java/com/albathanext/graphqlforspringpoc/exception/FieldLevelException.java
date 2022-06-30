package com.albathanext.graphqlforspringpoc.exception;

import lombok.Getter;

@Getter
public class FieldLevelException extends RuntimeException{
    private String invalidField;
    public FieldLevelException(String message, String invalidField) {
        super(message);
        this.invalidField = invalidField;
    }
}
