package com.example.petshow.petshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshow.mapper.DozerMapper;
import com.example.petshow.petshow.Exceptions.ResourceNotFoundException;
import com.example.petshow.petshow.model.Cliente;
import com.example.petshow.petshow.repository.ClienteRepositoy;
import com.example.petshow.petshow.view.DTO.ClienteDTO;

@Service
public class ClienteService {

    @Autowired
    ClienteRepositoy clienteRepositoy;

    public ClienteDTO findById(Long id) {

        var entity = clienteRepositoy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        
        return DozerMapper.parseObject(entity, ClienteDTO.class);


    }

    public List<ClienteDTO> findAll() {

        return  DozerMapper.parseListObject(clienteRepositoy.findAll(), ClienteDTO.class);

    }

    public ClienteDTO create(ClienteDTO cliente) {

        var entity = DozerMapper.parseObject(cliente, Cliente.class);

        var vo = DozerMapper.parseObject(clienteRepositoy.save(entity), ClienteDTO.class);

        return vo;
    }

    public ClienteDTO update(ClienteDTO cliente) {

        var entity = clienteRepositoy.findById(cliente.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setNome(cliente.getNome());
        entity.setCpf(cliente.getCpf());
        entity.setEmail(cliente.getEmail());
        entity.setTelefone(cliente.getTelefone());
        entity.setLogradouro(cliente.getLogradouro());
        entity.setNumero(cliente.getNumero());
        entity.setBairro(cliente.getBairro());
        entity.setCidade(cliente.getCidade());
        entity.setEstado(cliente.getEstado());
         
        var vo = DozerMapper.parseObject(clienteRepositoy.save(entity), ClienteDTO.class);

        return vo;
    }

    public void delete(Long id) {
        
        var entity = clienteRepositoy.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        clienteRepositoy.delete(entity);
    }

}
