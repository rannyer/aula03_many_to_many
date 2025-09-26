package com.example.projeto_many_to_many.controllers;

import com.example.projeto_many_to_many.models.Curso;
import com.example.projeto_many_to_many.services.CursoService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public Page<Curso> getAll(
          @Parameter(description = "Nome do curso") @RequestParam(required = false) String nome,
          @Parameter(description = "Categoria do curso")  @RequestParam(required = false) String categoria,
          @Parameter(description = "Carga horária minima")  @RequestParam(required = false) Integer cargaMin,
          @Parameter(description = "Status do curso (ativo, inativo)")  @RequestParam(required = false) String status,
          Pageable pageable
    ){
        return cursoService.filtrarCursos(nome, categoria, cargaMin, status, pageable);
    }

    @PostMapping
    public Curso add(@RequestBody Curso curso){
        return cursoService.salar(curso);
    }
}
