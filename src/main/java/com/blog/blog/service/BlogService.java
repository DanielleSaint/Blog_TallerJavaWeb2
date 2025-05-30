package com.blog.blog.service;
import com.blog.blog.model.Blog;
import com.blog.blog.repository.iBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogService implements iBlogService{
    private final iBlogRepository blogRepository;

    @Autowired
    public BlogService(iBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<Blog> obtenerTodos() {
        return blogRepository.findAll();
    }

    @Override
    public Blog obtenerPorId(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void updateBlog(Long id, Blog blogActualizado) {
        Blog blogExistente = blogRepository.findById(id).orElse(null);
        if(blogExistente != null){
            blogExistente.setTitulo(blogActualizado.getTitulo());
            blogExistente.setContenido(blogActualizado.getContenido());
            blogExistente.setAutor(blogActualizado.getAutor());
            blogRepository.save(blogExistente);
        }else{
            throw new RuntimeException("Publicación con id: " + id + " no encontrada");
        }
    }
}
