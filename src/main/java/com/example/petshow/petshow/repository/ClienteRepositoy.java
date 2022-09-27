package com.example.petshow.petshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.petshow.petshow.model.Cliente;

@Repository
public interface ClienteRepositoy extends JpaRepository<Cliente, Long> {
    
}
