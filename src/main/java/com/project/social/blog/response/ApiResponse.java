package com.project.social.blog.response;

public class ApiResponse<T> {
    /**
     requestId will help to uniquely identify the request across multiple services.
     */
    private String requestId;
    private String status;
    private int responseCode;
    private String responseMessage;
    private T payload;

    public ApiResponse(int responseCode) {
        this.responseCode = responseCode;
    }


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
