package com.example.petshow.petshow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;


//Model((Nome, Idade, Espécie, Sexo, Peso, Tutor (FK Cliente))
@Entity
@Table(name = "TB_PET")
@Data
@NoArgsConstructor
public class Pet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 15)
    private String idade;

    @Column(nullable = false, length = 30)
    private String especie;

    @Column(nullable = false, length = 15)
    private String sexo;

    @Column(nullable = false, length = 10)
    private String peso;
    
    @ManyToOne
    @JoinColumn(name = "Id_Cliente")
    private Cliente cliente;

    
  
}
