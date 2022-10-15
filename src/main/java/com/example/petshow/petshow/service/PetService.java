package com.example.petshow.petshow.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshow.petshow.Exceptions.ResourceNotFoundException;
import com.example.petshow.petshow.model.Pet;
import com.example.petshow.petshow.repository.PetRepositoy;


@Service
public class PetService {

    @Autowired
    PetRepositoy petRepository;

    public Pet findById(Long id) {

        var entity = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        
        return entity;

    }

    public List<Pet> findAll() {

        return  petRepository.findAll();

    }

    public Pet create(Pet cliente) {

        var vo = petRepository.save(cliente);

        return vo;
    }

    public Pet update(Pet pet) {

        var entity = petRepository.findById(pet.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setNome(pet.getNome());
        entity.setIdade(pet.getIdade());
        entity.setPeso(pet.getPeso());
        entity.setSexo(pet.getSexo());
        entity.setEspecie(pet.getEspecie());
        entity.setCliente(pet.getCliente());
        
         
        var vo = petRepository.save(entity);

        return vo;
    }

    public void delete(Long id) {
        
        var entity = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        petRepository.delete(entity);
    }

}
