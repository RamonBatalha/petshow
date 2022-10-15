package com.example.petshow.petshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshow.petshow.Exceptions.ResourceNotFoundException;
import com.example.petshow.petshow.model.Produto;
import com.example.petshow.petshow.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Produto create(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {

        var entity =  produtoRepository.findById(produto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setNome(produto.getNome());
        entity.setCategoria(produto.getCategoria());
        entity.setEstoque(produto.getEstoque());
        entity.setStatus(produto.getStatus());
        entity.setValorcompra(produto.getValorcompra());
        entity.setValorvenda(produto.getValorvenda());
    
        return produtoRepository.save(entity);
    }

    public void delete(Long id) {
        
        var entity = produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        produtoRepository.delete(entity);
    }
}
