package com.example.petshow.petshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshow.petshow.Exceptions.ResourceNotFoundException;
import com.example.petshow.petshow.model.Servico;
import com.example.petshow.petshow.repository.ServicoRepository;

@Service
public class ServicoService {
       
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico findById(Long id) {

        var entity = servicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        
        return entity;

    }

    public List<Servico> findAll() {

        return  servicoRepository.findAll();

    }

    public Servico create(Servico servico) {

        var vo = servicoRepository.save(servico);

        return vo;
    }

    public Servico update(Servico servico) {

        var entity = servicoRepository.findById(servico.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setDescricao(servico.getDescricao());
        entity.setStatus(servico.getStatus());
        entity.setStatus_pagamento(servico.getStatus_pagamento());
        entity.setObservacao(servico.getObservacao());
        
        var vo = servicoRepository.save(entity);

        return vo;
    }

    public void delete(Long id) {
        
        var entity = servicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        servicoRepository.delete(entity);
    }
}
