package com.blog.blog.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_blog;
    @NotBlank(message = "El título no puede estar vacío")
    @Column(nullable = false, length = 100)
    private String titulo;
    @NotBlank(message = "El contenido no puede estar vacío")
    @Column(nullable = false)
    private String contenido;
    @NotBlank(message = "El autor no puede estar vacío")
    @Column(nullable = false, length = 100)
    private String autor;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaActualizacion;

    @PrePersist // Para asginar la fecha al crear una nueva publicación
    public void fechaDeCreacion() {
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
    }
    @PreUpdate // Para actualizar la fecha de la publicacion
    public void fechaDeActualizacion() {
        this.fechaActualizacion = new Date();
    }

    public Blog() {}

    public Blog(Long id_blog, String titulo, String contenido, String autor) {
        this.id_blog = id_blog;
        this.titulo = titulo;
        this.contenido = contenido;
        this.autor = autor;
    }

    public Long getId_blog() {
        return id_blog;
    }

    public void setId_blog(Long id_blog) {
        this.id_blog = id_blog;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
