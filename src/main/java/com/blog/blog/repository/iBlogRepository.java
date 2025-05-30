package com.blog.blog.repository;
import com.blog.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface iBlogRepository extends JpaRepository<Blog, Long> {
//    List<Blog> findAll();
//    Blog findById(Long id);
//    void save(Blog blog);
}
