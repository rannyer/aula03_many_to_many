package com.example.projeto_many_to_many.services;

import com.example.projeto_many_to_many.models.Aluno;

import com.example.projeto_many_to_many.repositories.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Page<Aluno> buscarTodos(Pageable pageable){
        return alunoRepository.findAll(pageable);
    }

    public Aluno buscarPeloId(Long id){
        Optional<Aluno> aluno =  alunoRepository.findById(id);
        return aluno.orElse(null);
    }

    public Aluno criarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }
    public List<Aluno> buscarAlunosAprovados(){
        return alunoRepository.findByMediaGreaterThan(7.0);
    }
    public List<Aluno> buscarAlunoPorCidade(String cidade){
        return alunoRepository.findByCidade(cidade);
    }

    public List<Aluno> buscarPotHabilidadeNome(String nomeHabilidade){
        return alunoRepository.findByHabilidadesNomeContainingIgnoreCase(nomeHabilidade);
    }

    public List<Aluno> buscarPorHabilidadeId(Long id){
        return alunoRepository.findByHabilidadesId(id);
    }


}
