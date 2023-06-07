package com.project.social.blog.service.impl;

import com.project.social.blog.dto.BlogRequest;
import com.project.social.blog.entity.BlogEntity;
import com.project.social.blog.exception.ValidationException;
import com.project.social.blog.repository.BlogRepository;
import com.project.social.blog.response.BlogDetailsResponse;
import com.project.social.blog.service.BlogService;
import com.project.social.blog.util.NullOrEmptyUtil;
import com.project.social.blog.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.project.social.blog.enums.ErrorCodes.*;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Long createBlog(String authorization, BlogRequest blogRequest) {
        ValidationUtil.validateBlogRequest(blogRequest);
        Long userId = validateAndGetUserId(authorization);
        BlogEntity blog = new BlogEntity(userId, blogRequest.getTitle(),
                blogRequest.getContent());
        blog = blogRepository.save(blog);
        return blog.getId();
    }

    @Override
    public void updateBlog(String authorization, BlogRequest blogRequest) {
        ValidationUtil.validateBlogUpdateRequest(blogRequest);
        Long userId = validateAndGetUserId(authorization);
        blogRepository.UpdateBlogContent(userId, blogRequest.getBlogId(),
                blogRequest.getContent());
    }

    @Override
    public void deleteBlog(String authorization, Long blogId) {
        if(NullOrEmptyUtil.isNullOrEmpty(blogId)){
            //loggers
            new ValidationException(Request_VALIDATION_FAILURE.getErrorCode(),
                    Request_VALIDATION_FAILURE.getErrorMessage());
        }
        Long userId = validateAndGetUserId(authorization);
        blogRepository.deleteBlog(userId,blogId);
    }

    @Override
    public List<BlogDetailsResponse> getBlogs(String authorization, int offset, int limit) {
        Long userId = validateAndGetUserId(authorization);
        Pageable pageable = PageRequest.of(offset, limit);
        List<BlogEntity> blogs = blogRepository.getBlogs(userId, pageable);
        List<BlogDetailsResponse> blogDetails = new ArrayList<>(blogs.size());
        for(BlogEntity blog : blogs){
            blogDetails.add(new BlogDetailsResponse(blog.getId(), blog.getTitle(), blog.getContent()));
        }
        return blogDetails;
    }

    private Long validateAndGetUserId(String authorization){
        //hit oauth service to get validate user details. For now returning same user id
        return 1l;
    }


}
