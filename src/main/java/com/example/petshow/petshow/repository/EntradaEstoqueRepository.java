package com.example.petshow.petshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.petshow.petshow.model.EntradaEstoque;

@Repository
public interface EntradaEstoqueRepository extends JpaRepository<EntradaEstoque, Long>{
    
}
