package com.example.petshow.petshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshow.petshow.Exceptions.ResourceNotFoundException;
import com.example.petshow.petshow.model.Categoria;
import com.example.petshow.petshow.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Categoria create(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {

        var entity =  categoriaRepository.findById(categoria.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setNomecategoria(categoria.getNomecategoria());
    
        return categoriaRepository.save(entity);
    }

    public void delete(Long id) {
        
        var entity = categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        categoriaRepository.delete(entity);
    }
}
