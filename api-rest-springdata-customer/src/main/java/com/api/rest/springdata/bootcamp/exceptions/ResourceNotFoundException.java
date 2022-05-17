package com.api.rest.springdata.bootcamp.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("'%s' Not found with: '%s' : '%s'", resourceName, fieldName, fieldValue));
    }

}
