package com.example.act3_t4.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "escuelas")
public class Escuela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String clave;

    @OneToMany(mappedBy = "escuela", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alumno> alumnos;

    public Escuela() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}