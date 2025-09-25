package com.example.projeto_many_to_many.controllers;

import com.example.projeto_many_to_many.models.Habilidade;
import com.example.projeto_many_to_many.services.HabilidadeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidade")
public class HabilidadeController {


    @Autowired
    private HabilidadeService habilidadeService;

    @GetMapping
    public ResponseEntity<Page<Habilidade>> getAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "3") int size,
                                                   @RequestParam(defaultValue = "id") String sort,
                                                   @RequestParam(defaultValue = "asc") String direction){
        return ResponseEntity.ok(habilidadeService.buscarTodas(page, size, sort, direction));
    }
    @PostMapping
    public Habilidade add(@RequestBody Habilidade habilidade){
        return habilidadeService.criarHabilidade(habilidade);
    }




}
