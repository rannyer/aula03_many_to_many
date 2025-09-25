package com.example.projeto_many_to_many.services;

import com.example.projeto_many_to_many.models.Aluno;
import com.example.projeto_many_to_many.models.Habilidade;
import com.example.projeto_many_to_many.repositories.HabilidadeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabilidadeService {
    private HabilidadeRepository habilidadeRepository;

    public HabilidadeService(HabilidadeRepository habilidadeRepository) {
        this.habilidadeRepository = habilidadeRepository;
    }

    public Page<Habilidade> buscarTodas(int page, int size, String sortBy, String direction){
        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return habilidadeRepository.findAll(pageable);
    }


    public Habilidade buscarPeloId(Long id){
        Optional<Habilidade> habilidade =  habilidadeRepository.findById(id);
        return habilidade.orElse(null);
    }

    public Habilidade criarHabilidade(Habilidade habilidade){
        return habilidadeRepository.save(habilidade);
    }



}
