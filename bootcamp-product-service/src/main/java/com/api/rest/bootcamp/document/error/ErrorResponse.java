package com.api.rest.bootcamp.document.error;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    /**
     * error code.
     */
    private int errorCode;
    /**
     * message.
     */
    private String message;
}
