package br.com.artur.check.password.api.exceptions;

public class BusinessException extends ErrorCodeException {

    public BusinessException(String message, String errorCode) {
        super(message, errorCode);
    }
}
