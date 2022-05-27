package com.api.rest.bootcamp.document.error;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    /**
     * code error.
     */
    private int errorCode;
    /**
     * message.
     */
    private String message;
}
