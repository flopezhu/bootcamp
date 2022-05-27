package com.api.rest.bootcamp.document.error;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
