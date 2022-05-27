package com.api.rest.bootcamp.document.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
