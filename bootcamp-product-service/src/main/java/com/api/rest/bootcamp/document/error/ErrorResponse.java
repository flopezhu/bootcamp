package com.api.rest.bootcamp.document.error;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private String message;
}
