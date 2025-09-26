package com.example.projeto_many_to_many.controllers;

import com.example.projeto_many_to_many.models.Aluno;
import com.example.projeto_many_to_many.services.AlunoService;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public Page<Aluno> getAll(@PageableDefault(size = 5, sort = "nome") Pageable pageable){
        return alunoService.buscarTodos(pageable);
    }

    @PostMapping
    public Aluno add(@RequestBody Aluno aluno){
        return alunoService.criarAluno(aluno);
    }

    @GetMapping("/aprovados")
    public List<Aluno> getAprovados(){
        return alunoService.buscarAlunosAprovados();
    }

    @Hidden //esconde o endpoint no swagger
    @GetMapping("/cidade/{cidade}")
    public List<Aluno> getAlunosByCidade(@PathVariable String cidade){
        return alunoService.buscarAlunoPorCidade(cidade);
    }

    @GetMapping("/habilidade")
    public List<Aluno> getAlunosByHabilidadeNome(@RequestParam String nome){
        return alunoService.buscarPotHabilidadeNome(nome);
    }
    @GetMapping("/habilidade/{id}")
    public List<Aluno> getAlunosByHabilidade(@PathVariable Long id){
        return alunoService.buscarPorHabilidadeId(id);
    }





}
