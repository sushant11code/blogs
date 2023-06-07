package com.project.social.blog.repository;

import com.project.social.blog.entity.BlogEntity;
import com.project.social.blog.response.BlogDetailsResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

    @Transactional
    @Modifying
    @Query("update BlogEntity b set b.content = ?3 where b.userId = ?1 and b.id=?2")
    void UpdateBlogContent(Long userId, Long blogId, String content);

    @Transactional
    @Modifying
    @Query("delete from BlogEntity b where b.userId = ?1 and b.id = ?2")
    void deleteBlog(Long userId, Long blogId);

    @Query("select b from BlogEntity b where b.userId = ?1")
    List<BlogEntity> getBlogs(Long userId, Pageable pageable);
}
