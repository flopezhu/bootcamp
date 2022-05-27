package com.api.rest.bootcamp.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
     * @param resourceName
     * @param fieldName
     * @param fieldValue
     */
    public ResourceNotFoundException(final String resourceName,
                                     final String fieldName,
                                     final String fieldValue) {
        super(String.format("'%s' Not found with: '%s' : '%s'",
                resourceName, fieldName, fieldValue));
    }
}
