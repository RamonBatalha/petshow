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

import com.example.petshow.petshow.model.SaidaEstoque;
import com.example.petshow.petshow.service.SaidaEstoqueService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/saidaestoque")
public class SaidaEstoqueController {
    
    @Autowired
    private SaidaEstoqueService saidaEstoqueService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SaidaEstoque findById(@PathVariable(value = "id") Long id) {
        return saidaEstoqueService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SaidaEstoque> findAll() {
        return saidaEstoqueService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SaidaEstoque> create(@RequestBody SaidaEstoque saidaEstoque) {
        // return clienteService.create(cliente);
        return new ResponseEntity(saidaEstoqueService.create(saidaEstoque), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SaidaEstoque update(@RequestBody SaidaEstoque saidaEstoque) {
        return saidaEstoqueService.update(saidaEstoque);
    }
     
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        saidaEstoqueService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
