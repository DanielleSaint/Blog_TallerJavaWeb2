//package com.blog.blog.repository;
//import com.blog.blog.model.Blog;
//import org.springframework.stereotype.Repository;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public class BlogRepository implements iBlogRepository{
//    private final List<Blog> blogs = new ArrayList<>();
//
//    public BlogRepository() {
//        blogs.add(new Blog(
//                2L,
//                "Consejos de programación",
//                "Practicar todos los días mejora tus habilidades.",
//                "Dani"));
//        blogs.add(new Blog(
//                3L,
//                "Errores comunes en Java",
//                "Uno de los errores más comunes es olvidar el punto y coma.",
//                "MJ"));
//    }
//
//    @Override
//    public List<Blog> findAll() {
//        return blogs;
//    }
//
//    @Override
//    public Blog findById(Long id) {
//        for (Blog blog : blogs){
//            if(blog.getId_blog().equals(id)){
//                return blog;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void save(Blog blog) {
//        blogs.add(blog);
//    }
//}
