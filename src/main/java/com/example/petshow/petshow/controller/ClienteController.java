package com.example.petshow.petshow.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshow.petshow.service.ClienteService;
import com.example.petshow.petshow.view.DTO.ClienteDTO;


@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value="/{id}", 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO findById(@PathVariable(value="id") Long id) {
        return clienteService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteDTO> findAll() {
        return clienteService.findAll();
    }

    @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO cliente) {
        // return clienteService.create(cliente);
        return new ResponseEntity(clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO update(@RequestBody ClienteDTO cliente) {
        return clienteService.update(cliente);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        clienteService.delete(id);

        return ResponseEntity.noContent().build();
    }
       
    
}
