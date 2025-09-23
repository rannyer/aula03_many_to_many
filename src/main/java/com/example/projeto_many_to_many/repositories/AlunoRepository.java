package com.example.projeto_many_to_many.repositories;

import com.example.projeto_many_to_many.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {


    List<Aluno> findByMediaGreaterThan(double media);
    List<Aluno> findByCidade(String cidade);
    List<Aluno> findByHabilidadesNomeContainingIgnoreCase(String nome);
    List<Aluno> findByHabilidadesId(Long id);




//    List<Aluno> findByCidadeAndNotaGreaterThan(String cidade, double nota);

//    @Query("SELECT a FROM ALUNO a where a.cidade = :cidade AND a.media_final > :nota")
//    List<Aluno> buscarPorCidadeENotaMaior(
//            @Param("cidade") String cidade,
//            @Param("nota") double nota
//    );

//    @Query("SELECT a FROM ALUNO a where a.cidade = ?1 AND a.media_final > ?2")
//    List<Aluno> buscarPorCidadeENotaMaior(String cidade,double nota);


}
