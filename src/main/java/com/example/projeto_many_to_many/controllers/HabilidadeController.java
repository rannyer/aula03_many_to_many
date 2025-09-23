package com.example.projeto_many_to_many.controllers;

import com.example.projeto_many_to_many.models.Habilidade;
import com.example.projeto_many_to_many.services.HabilidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidade")
public class HabilidadeController {


    @Autowired
    private HabilidadeService habilidadeService;

    @GetMapping
    public List<Habilidade> getAll(){
        return habilidadeService.buscarTodos();
    }
    @PostMapping
    public Habilidade add(@RequestBody Habilidade habilidade){
        return habilidadeService.criarHabilidade(habilidade);
    }




}
