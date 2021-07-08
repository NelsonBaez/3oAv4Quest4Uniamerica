package com.example.av4questao43o.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Empresa extends BaseEntity {

    @NotBlank(message = "o nome da Empresa é obrigatoria")
    private String nome;

    @JsonManagedReference
    @OneToMany(mappedBy="empresa")
    private List<Produto> produtos = new ArrayList<>();
}
