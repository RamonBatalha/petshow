package com.example.petshow.petshow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshow.petshow.model.Servico;
import com.example.petshow.petshow.service.ServicoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/servicos")
public class ServicoController {
    
    @Autowired
    private ServicoService servicoService;

    @GetMapping(value="/{id}", 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Servico findById(@PathVariable(value="id") Long id) {
        return servicoService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Servico> findAll() {
        return servicoService.findAll();
    }

    @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Servico> create(@RequestBody Servico servico) {
        // return clienteService.create(servico);
        return new ResponseEntity(servicoService.create(servico), HttpStatus.CREATED);
    }

    @PutMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Servico update(@RequestBody Servico servico) {
        return servicoService.update(servico);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        servicoService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
