package com.example.petshow.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_PRODUTOS")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    @Column(name = "nome", nullable = false, length = 80 )
    private String nome;

    @Column(name = "estoque", nullable = false)
    private float estoque;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "valor_compra", nullable = false)
    private float valorcompra;

    @Column(name = "valor_venda", nullable = false)
    private float valorvenda;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    public Produto(Long id, String nome, float estoque, Integer status, float valorcompra, float valorvenda,
            Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.status = status;
        this.valorcompra = valorcompra;
        this.valorvenda = valorvenda;
        this.categoria = categoria;
    }


}
