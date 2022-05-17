package com.api.rest.springboot.bootcamp.documents.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private String message;
}
