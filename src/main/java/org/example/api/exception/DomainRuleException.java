package org.example.api.exception;

public class DomainRuleException extends RuntimeException {

    public DomainRuleException(String message) {
        super(message);
    }

    public DomainRuleException(String message, Throwable cause) {
        super(message, cause);
    }
}
