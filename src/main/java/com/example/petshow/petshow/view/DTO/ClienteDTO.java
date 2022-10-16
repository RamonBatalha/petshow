package com.example.petshow.petshow.view.DTO;

import java.util.List;

import com.example.petshow.petshow.model.Pet;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
    
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;

    private List<Pet> pet;
    

    

}
