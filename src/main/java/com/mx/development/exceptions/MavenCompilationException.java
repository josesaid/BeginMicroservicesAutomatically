package com.mx.development.exceptions;

public class MavenCompilationException extends RuntimeException {
    public MavenCompilationException(String message, Exception e) {
        super(message);
        e.printStackTrace();
    }
    public MavenCompilationException(String message) {
        super(message);
    }


}
