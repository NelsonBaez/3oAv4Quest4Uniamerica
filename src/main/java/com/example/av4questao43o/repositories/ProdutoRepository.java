package com.example.av4questao43o.repositories;

import com.example.av4questao43o.models.Empresa;
import com.example.av4questao43o.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByEmpresa(Empresa empresa);
}
