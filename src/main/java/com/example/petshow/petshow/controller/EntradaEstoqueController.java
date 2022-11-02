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

import com.example.petshow.petshow.model.EntradaEstoque;
import com.example.petshow.petshow.service.EntradaEstoqueService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/entradaestoque")
public class EntradaEstoqueController {
         
    @Autowired
    private EntradaEstoqueService entradaEstoqueService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntradaEstoque findById(@PathVariable(value = "id") Long id) {
        return entradaEstoqueService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EntradaEstoque> findAll() {
        return entradaEstoqueService.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntradaEstoque> create(@RequestBody EntradaEstoque entradaEstoque) {
        // return clienteService.create(cliente);
        return new ResponseEntity(entradaEstoqueService.create(entradaEstoque), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntradaEstoque update(@RequestBody EntradaEstoque entradaEstoque) {
        return entradaEstoqueService.update(entradaEstoque);
    }
     
    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        entradaEstoqueService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
