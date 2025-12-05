package com.backend_wpost.exception;

public class ResourceNotFoundException extends RuntimeException {

    // Constructor con mensaje
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Constructor con mensaje y causa (opcional)
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor por defecto (sin argumentos)
    public ResourceNotFoundException() {
        super();
    }
}