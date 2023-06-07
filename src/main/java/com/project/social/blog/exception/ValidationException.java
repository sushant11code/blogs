package com.project.social.blog.exception;

public class ValidationException extends RuntimeException{

    private int errorCode;

    public ValidationException(int errorCode, String errorMessage){
    super(errorMessage);
    this.errorCode = errorCode;
}

    public int getErrorCode() {
        return errorCode;
    }
}
