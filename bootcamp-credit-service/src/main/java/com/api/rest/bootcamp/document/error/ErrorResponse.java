package com.api.rest.bootcamp.document.error;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private String message;
}
