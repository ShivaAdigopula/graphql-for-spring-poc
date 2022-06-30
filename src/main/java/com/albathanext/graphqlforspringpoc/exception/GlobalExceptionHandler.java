package com.albathanext.graphqlforspringpoc.exception;

import graphql.GraphQLError;
import graphql.GraphqlErrorException;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class GlobalExceptionHandler extends DataFetcherExceptionResolverAdapter {

    public GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {

        if (ex instanceof FieldLevelException) {
            FieldLevelException fle = (FieldLevelException) ex;
            return GraphqlErrorException.newErrorException().message(ex.getMessage()).extensions(Collections.singletonMap("invalidField", fle.getInvalidField())).build();
        }
        return GraphqlErrorException.newErrorException().message(ex.getMessage()).build();
    }
}
