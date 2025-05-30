package com.blog.blog.controller;
import com.blog.blog.model.Blog;
import com.blog.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping // Traer t0dos los blogs
    public List<Blog> listaBlogs(){
        return blogService.obtenerTodos();
    }

    @GetMapping("/{id}") // ruta ->/posts/{id}
    public Blog obtenerPorId(@PathVariable Long id){
        return blogService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarBlog(@RequestBody Blog blog) {
        blogService.guardarBlog(blog);
        return ResponseEntity.ok("Publicación guardada con exito");
    }

    @DeleteMapping ("/borrar/{id}") // ruta ->/posts/borrar/{id}
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Publicación eliminada con exito");
    }

    @PutMapping ("/editar/{id}") // ruta ->/posts/editar/{id}
    public ResponseEntity<String> editarBlog(@PathVariable Long id, @RequestBody Blog blogActualizado){
        blogService.updateBlog(id, blogActualizado);
        return ResponseEntity.ok("Publicación actualizada con exito");
    }
}
