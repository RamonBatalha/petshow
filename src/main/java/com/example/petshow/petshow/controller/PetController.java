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

import com.example.petshow.petshow.model.Pet;
import com.example.petshow.petshow.service.PetService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/pet")
public class PetController {
    
    @Autowired
    private PetService petService;

    @GetMapping(value="/{id}", 
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Pet findById(@PathVariable(value="id") Long id) {
        return petService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pet> findAll() {
        return petService.findAll();
    }

    @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> create(@RequestBody Pet cliente) {
        // return clienteService.create(cliente);
        return new ResponseEntity(petService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Pet update(@RequestBody Pet cliente) {
        return petService.update(cliente);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        petService.delete(id);

        return ResponseEntity.noContent().build();
    }
       
    
}
