package com.example.petshow.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_CATEGORIA")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "nome_categoria", nullable = false, length = 20 )
    private String nomecategoria;

    public Categoria(Long id, String nomecategoria) {
        this.id = id;
        this.nomecategoria = nomecategoria;
    }
     
    
}
