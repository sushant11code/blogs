package com.project.social.blog.util;

import com.project.social.blog.dto.BlogRequest;
import com.project.social.blog.exception.ValidationException;

import static com.project.social.blog.enums.ErrorCodes.*;

public class ValidationUtil {
    public static void validateBlogRequest(BlogRequest blogRequest){
        if(NullOrEmptyUtil.isNullOrEmpty(blogRequest.getTitle())){
            //loggers
            new ValidationException(Request_VALIDATION_FAILURE.getErrorCode(),
                    Request_VALIDATION_FAILURE.getErrorMessage());
        }
        if(NullOrEmptyUtil.isNullOrEmpty(blogRequest.getContent())){
            //loggers
            new ValidationException(Request_VALIDATION_FAILURE.getErrorCode(),
                    Request_VALIDATION_FAILURE.getErrorMessage());
        }
        //validate blog size
    }

    public static void validateBlogUpdateRequest(BlogRequest blogRequest){
        if(NullOrEmptyUtil.isNullOrEmpty(blogRequest.getContent())){
            //loggers
            new ValidationException(Request_VALIDATION_FAILURE.getErrorCode(),
                    Request_VALIDATION_FAILURE.getErrorMessage());
        }
        if(NullOrEmptyUtil.isNullOrEmpty(blogRequest.getBlogId())){
            //loggers
            new ValidationException(Request_VALIDATION_FAILURE.getErrorCode(),
                    Request_VALIDATION_FAILURE.getErrorMessage());
        }
        //validate blog size
    }
}
