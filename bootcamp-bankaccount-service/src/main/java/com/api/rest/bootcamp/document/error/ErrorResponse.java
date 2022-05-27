package com.api.rest.bootcamp.document.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
