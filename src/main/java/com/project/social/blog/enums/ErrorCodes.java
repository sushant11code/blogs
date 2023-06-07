package com.project.social.blog.enums;

public enum ErrorCodes {

    Request_VALIDATION_FAILURE(400, "Request validation failed.");
    ErrorCodes(int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private int errorCode;
    private String errorMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
