package br.com.artur.check.password.api.exceptions;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ErrorCodeException extends RuntimeException {

    private final String errorCode;

    public ErrorCodeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
