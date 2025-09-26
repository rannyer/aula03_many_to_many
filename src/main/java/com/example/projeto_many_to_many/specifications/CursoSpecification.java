package com.example.projeto_many_to_many.specifications;

import com.example.projeto_many_to_many.models.Curso;
import org.springframework.data.jpa.domain.Specification;

public class CursoSpecification {

    public static Specification<Curso> comNome(String nome){
        return ((root, query, cb) ->
                nome == null ? null : cb.like(cb.lower(root.get("nome")), "%"+nome.toLowerCase()+"%")
                );
    }

    public static Specification<Curso> comCategoria(String categoria){
        return ((root, query, cb) ->
                categoria == null ? null : cb.equal(root.get("categoria"), categoria)
        );
    }

    public static Specification<Curso> comCargaHorariaMin(Integer cargaMin){
        return ((root, query, cb) ->
                cargaMin == null ? null : cb.greaterThanOrEqualTo(root.get("cargaHoraria"), cargaMin)
        );
    }
    public static Specification<Curso> comStatus(String status){
        return ((root, query, cb) ->
                status == null ? null : cb.equal(root.get("status"), status)
        );
    }


}
