package com.project.social.blog.enums;

public enum ApiResponseStatus {
    SUCCESS("Success"),
    FAILURE("Failure");

    private String value;
    ApiResponseStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
