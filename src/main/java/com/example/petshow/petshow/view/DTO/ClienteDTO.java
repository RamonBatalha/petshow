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
    private String endereco;

    private List<Pet> pet;
    

    

}
