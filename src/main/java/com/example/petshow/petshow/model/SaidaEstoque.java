package com.example.petshow.petshow.model;

import java.util.Date;

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
@Table(name = "tb_saida_estoque")
public class SaidaEstoque {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private float valor;

    @Column(nullable = false)
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public SaidaEstoque(Long id, Date data, float valor) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        
    }

    
}
