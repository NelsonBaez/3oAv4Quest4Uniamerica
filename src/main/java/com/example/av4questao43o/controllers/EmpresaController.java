package com.example.av4questao43o.controllers;

import com.example.av4questao43o.models.Empresa;
import com.example.av4questao43o.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public List<Empresa> findAll() {
        return empresaService.findAll();
    }

    @PostMapping
    public Empresa create(@Valid @RequestBody Empresa empresa){
        return empresaService.create(empresa);
    }

    @PutMapping("/{id}")
    public Empresa update(@PathVariable("id") Integer id, @Valid @RequestBody Empresa empresa){
        return empresaService.update(id, empresa);
    }

    @DeleteMapping("/{id}")
    public String destroy(@PathVariable("id") Integer id){
        return empresaService.destroy(id);
    }

    @GetMapping("/{id}")
    public Empresa find(@PathVariable("id") Integer id) {
        return empresaService.find(id);
    }

}
