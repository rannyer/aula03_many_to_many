package com.example.projeto_many_to_many.services;

import com.example.projeto_many_to_many.models.Aluno;
import com.example.projeto_many_to_many.models.Habilidade;
import com.example.projeto_many_to_many.repositories.HabilidadeRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabilidadeService {
    private HabilidadeRepository habilidadeRepository;

    public HabilidadeService(HabilidadeRepository habilidadeRepository) {
        this.habilidadeRepository = habilidadeRepository;
    }

    public List<Habilidade> buscarTodos(){
        return habilidadeRepository.findAll();
    }

    public Habilidade buscarPeloId(Long id){
        Optional<Habilidade> habilidade =  habilidadeRepository.findById(id);
        return habilidade.orElse(null);
    }

    public Habilidade criarHabilidade(Habilidade habilidade){
        return habilidadeRepository.save(habilidade);
    }



}
