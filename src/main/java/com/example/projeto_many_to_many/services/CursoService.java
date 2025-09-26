package com.example.projeto_many_to_many.services;

import ch.qos.logback.core.pattern.SpacePadder;
import com.example.projeto_many_to_many.models.Curso;
import com.example.projeto_many_to_many.repositories.CursoRepository;
import com.example.projeto_many_to_many.specifications.CursoSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> filtrarCursos(String nome, String categoria, Integer cargaMin, String status){

//      Specification<Curso> spec2 = (root, query, cb) -> cb.conjunction();

        Specification<Curso> spec = Specification.anyOf();

        spec = spec.and(CursoSpecification.comNome(nome))
                .and(CursoSpecification.comCategoria(categoria))
                .and(CursoSpecification.comCargaHorariaMin(cargaMin))
                .and(CursoSpecification.comStatus(status));

        return cursoRepository.findAll(spec);
    }

    public Curso salar(Curso curso){
        return cursoRepository.save(curso);
    }

}
