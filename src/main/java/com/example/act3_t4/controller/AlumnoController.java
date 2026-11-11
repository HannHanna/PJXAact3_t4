package com.example.act3_t4.controller;

import com.example.act3_t4.model.Alumno;
import com.example.act3_t4.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoService.listarAlumnos());
        return "alumnos"; // Vista de Thymeleaf que crearemos después
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistrarAlumno(Model model) {
        Alumno alumno = new Alumno();
        model.addAttribute("alumno", alumno);
        return "crear_alumno";
    }

    @PostMapping
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoService.guardarAlumno(alumno);
        return "redirect:/alumnos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model model) {
        model.addAttribute("alumno", alumnoService.obtenerAlumnoPorId(id).get());
        return "editar_alumno";
    }

    @PostMapping("/{id}")
    public String actualizarAlumno(@PathVariable Long id, @ModelAttribute("alumno") Alumno alumno, Model model) {
        Alumno alumnoExisting = alumnoService.obtenerAlumnoPorId(id).get();
        alumnoExisting.setId(id);
        alumnoExisting.setNombre(alumno.getNombre());
        alumnoExisting.setApellido(alumno.getApellido());
        alumnoExisting.setEmail(alumno.getEmail());

        alumnoService.guardarAlumno(alumnoExisting);
        return "redirect:/alumnos";
    }

    @GetMapping("/{id}")
    public String eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
        return "redirect:/alumnos";
    }
}