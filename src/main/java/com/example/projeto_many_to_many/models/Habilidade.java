package com.example.projeto_many_to_many.models;
import com.example.projeto_many_to_many.models.Aluno;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Habilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnoreProperties("habilidades")
    @ManyToMany(mappedBy = "habilidades")
    private Set<Aluno> alunos =  new HashSet<>();

    public Habilidade(Long id, String nome, Set<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.alunos = alunos;
    }

    public Habilidade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }
}
