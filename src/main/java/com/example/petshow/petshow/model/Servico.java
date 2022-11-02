package com.example.petshow.petshow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.petshow.petshow.model.enums.statusPagamento;
import com.example.petshow.petshow.model.enums.statusServico;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "TB_SERVICO")
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=50)
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private statusServico status;
    
    @Enumerated(EnumType.STRING)
    private statusPagamento status_pagamento;
     
    @Column(length=80)
    private String observacao;
    
    @Column(nullable = false)
    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "id_pet")
    private Pet pet;

 
} 
