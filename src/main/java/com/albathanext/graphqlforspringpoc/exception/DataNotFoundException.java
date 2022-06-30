package com.albathanext.graphqlforspringpoc.exception;

import graphql.GraphQLException;
import lombok.AllArgsConstructor;


public class DataNotFoundException extends GraphQLException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
