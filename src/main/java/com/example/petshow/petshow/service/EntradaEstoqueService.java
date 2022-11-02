package com.example.petshow.petshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshow.petshow.Exceptions.ResourceNotFoundException;
import com.example.petshow.petshow.model.EntradaEstoque;
import com.example.petshow.petshow.repository.EntradaEstoqueRepository;

@Service
public class EntradaEstoqueService {
      
    @Autowired
    private EntradaEstoqueRepository entradaEstoqueRepository;

    public List<EntradaEstoque> findAll(){
        return entradaEstoqueRepository.findAll();
    }

    public EntradaEstoque findById(Long id){
        return entradaEstoqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public EntradaEstoque create(EntradaEstoque entradaEstoque){
        return entradaEstoqueRepository.save(entradaEstoque);
    }

    public EntradaEstoque update(EntradaEstoque entradaEstoque) {

        var entity =  entradaEstoqueRepository.findById(entradaEstoque.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setValor(entradaEstoque.getValor());
        entity.setData(entradaEstoque.getData());
    
        return entradaEstoqueRepository.save(entity);
    }

    public void delete(Long id) {
        
        var entity = entradaEstoqueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entradaEstoqueRepository.delete(entity);
    }
}
