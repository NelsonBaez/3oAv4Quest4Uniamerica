package com.example.av4questao43o.controllers;

import com.example.av4questao43o.models.Produto;
import com.example.av4questao43o.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id_produto}")
    public Produto find(@PathVariable Integer id_produto){
        return produtoService.find(id_produto);
    }

    @PutMapping("/{id_produto}")
    public Produto update(@Valid @RequestBody Produto produto, @PathVariable Integer id_produto){
        return produtoService.update(id_produto, produto);
    }

    @DeleteMapping("/{id_produto}")
    public String destroy(@PathVariable Integer id_produto){
        return produtoService.destroy(id_produto);
    }


}
