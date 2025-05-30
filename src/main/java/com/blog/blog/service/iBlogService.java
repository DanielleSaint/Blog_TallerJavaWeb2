package com.blog.blog.service;
import com.blog.blog.model.Blog;
import java.util.List;

public interface iBlogService {
    List<Blog> obtenerTodos();
    Blog obtenerPorId(Long id);
    void guardarBlog(Blog blog);
    void deleteBlog(Long id);
    void updateBlog(Long id, Blog blogActualizado);
}
