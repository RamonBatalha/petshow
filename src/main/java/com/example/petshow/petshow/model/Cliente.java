package com.example.petshow.petshow.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_CLIENTE")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cpf;

    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 20)
    private String email;
     
    @Column(nullable = false, length = 80)
    private String logradouro;
     
    @Column(nullable = false, length = 10)
    private String numero;
     
    @Column(nullable = false, length = 20)
    private String bairro;
     
    @Column(nullable = false, length = 20)
    private String cidade;
    
    @Column(nullable = false, length = 2)
    private String estado;
     
    @JsonBackReference //poderia ser o jsonignorer, dava no mesmo
    @OneToMany(mappedBy = "cliente")
    private List<Pet> pet;


}
