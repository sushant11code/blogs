package com.project.social.blog.service;

import com.project.social.blog.dto.BlogRequest;
import com.project.social.blog.response.BlogDetailsResponse;

import java.util.List;

public interface BlogService {
    Long createBlog(String authorization, BlogRequest blogRequest);
    void updateBlog(String authorization, BlogRequest blogRequest);
    void deleteBlog(String authorization, Long blogId);
    List<BlogDetailsResponse> getBlogs(String authorization, int offset, int limit);
}
