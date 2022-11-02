package com.example.petshow.petshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshow.petshow.Exceptions.ResourceNotFoundException;
import com.example.petshow.petshow.model.SaidaEstoque;
import com.example.petshow.petshow.repository.SaidaEstoqueRepository;

@Service
public class SaidaEstoqueService {
    
    @Autowired
    private SaidaEstoqueRepository saidaEstoqueRepository;

    public List<SaidaEstoque> findAll(){
        return saidaEstoqueRepository.findAll();
    }

    public SaidaEstoque findById(Long id){
        return saidaEstoqueRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public SaidaEstoque create(SaidaEstoque saidaEstoque){
        return saidaEstoqueRepository.save(saidaEstoque);
    }

    public SaidaEstoque update(SaidaEstoque saidaEstoque) {

        var entity =  saidaEstoqueRepository.findById(saidaEstoque.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setValor(saidaEstoque.getValor());
        entity.setData(saidaEstoque.getData());
    
        return saidaEstoqueRepository.save(entity);
    }

    public void delete(Long id) {
        
        var entity = saidaEstoqueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        saidaEstoqueRepository.delete(entity);
    }
}
