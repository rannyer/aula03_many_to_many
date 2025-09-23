package com.example.projeto_many_to_many.models;

import com.example.projeto_many_to_many.models.Habilidade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "media_final")
    private double media;

    private String cidade;

    @ManyToMany
    @JoinTable(
            name = "aluno_habilidade",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "habilidade_id")
    )
    @JsonIgnoreProperties("alunos")
    private Set<Habilidade> habilidades =  new HashSet<>();

    public Aluno() {
    }

    public Aluno(Long id, String nome, double media, String cidade, Set<Habilidade> habilidades) {
        this.id = id;
        this.nome = nome;
        this.media = media;
        this.cidade = cidade;
        this.habilidades = habilidades;
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

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Set<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Set<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }
}
