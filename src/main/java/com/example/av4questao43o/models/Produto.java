package com.example.av4questao43o.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class Produto extends BaseEntity {
    @NotBlank(message = "o Nome do produto é obrigatorio")
    private String nome;

    @NotNull(message = "O preço é obrigatório.")
    private Double preco;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;
}
