package com.example.av4questao43o.services;

import com.example.av4questao43o.models.Empresa;
import com.example.av4questao43o.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa find(Integer id) {
        return empresaRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Empresa não Existe. id: " + id)
        );
    }

    @Transactional
    public Empresa update(Integer id, Empresa empresaNew) {
        Empresa empresa = this.find(id);
        empresa.setNome(empresaNew.getNome());
        return empresa;
    }

    public String destroy(Integer id) {
        Empresa empresa = this.find(id);
        empresaRepository.delete(empresa);
        return "empresa: " + empresa.getNome() + " foi Deletada com Sucesso!";
    }
}
