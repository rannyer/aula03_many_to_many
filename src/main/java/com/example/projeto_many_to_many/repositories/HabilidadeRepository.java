package com.example.projeto_many_to_many.repositories;

import com.example.projeto_many_to_many.models.Habilidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
    Page<Habilidade> findAll(Pageable pageable);
}
