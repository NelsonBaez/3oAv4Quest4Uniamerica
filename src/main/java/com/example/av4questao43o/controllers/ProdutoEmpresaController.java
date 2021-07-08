package com.example.av4questao43o.controllers;

import com.example.av4questao43o.models.Produto;
import com.example.av4questao43o.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresas/{id_empresa}/produtos")
public class ProdutoEmpresaController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll(@PathVariable Integer id_empresa) {
        return produtoService.findAll(id_empresa);
    }

    @PostMapping
    public Produto create(@Valid @RequestBody Produto produto, @PathVariable Integer id_empresa){
        return produtoService.create(id_empresa, produto);
    }
}
