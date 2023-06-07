package com.project.social.blog.controller;

import com.project.social.blog.dto.BlogRequest;
import com.project.social.blog.enums.ApiResponseStatus;
import com.project.social.blog.response.ApiResponse;
import com.project.social.blog.response.BlogDetailsResponse;
import com.project.social.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ApiResponse<Long> createNewPost(@RequestHeader String authorization,
                                           @RequestBody BlogRequest postRequest) {
        Long blogId = blogService.createBlog(authorization, postRequest);
        ApiResponse<Long> apiResponse = new ApiResponse<>(HttpStatus.OK.value());
        apiResponse.setPayload(blogId);
        apiResponse.setStatus(ApiResponseStatus.SUCCESS.getValue());
        apiResponse.setResponseMessage("Blog created successfully");
        return apiResponse;
    }

    @PutMapping
    public ApiResponse<?> updatePost(@RequestHeader String authorization,
                                     @RequestBody BlogRequest postRequest) {
        blogService.updateBlog(authorization, postRequest);
        ApiResponse<?> apiResponse = new ApiResponse<>(HttpStatus.OK.value());
        apiResponse.setPayload(null);
        apiResponse.setStatus(ApiResponseStatus.SUCCESS.getValue());
        apiResponse.setResponseMessage("Blog updated successfully");
        return apiResponse;
    }

    @DeleteMapping("id/{id}")
    public ApiResponse<?> deletePost(@RequestHeader String authorization,
                                     @PathVariable("id") Long blogId) {
        blogService.deleteBlog(authorization, blogId);
        ApiResponse<?> apiResponse = new ApiResponse<>(HttpStatus.OK.value());
        apiResponse.setPayload(null);
        apiResponse.setStatus(ApiResponseStatus.SUCCESS.getValue());
        apiResponse.setResponseMessage("Blog deleted successfully");
        return apiResponse;
    }

    @GetMapping
    public ApiResponse<List<BlogDetailsResponse>> getBlogs(@RequestHeader String authorization,
                                                           @RequestParam int offset,
                                                           @RequestParam int limit) {
        List<BlogDetailsResponse> blogs =  blogService.getBlogs(authorization, offset, limit);
        ApiResponse<List<BlogDetailsResponse>> apiResponse = new ApiResponse<>(HttpStatus.OK.value());
        apiResponse.setPayload(blogs);
        apiResponse.setStatus(ApiResponseStatus.SUCCESS.getValue());
        apiResponse.setResponseMessage("Blog fetched successfully");
        return apiResponse;
    }
}
