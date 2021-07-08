package com.example.av4questao43o.services;

import com.example.av4questao43o.models.Empresa;
import com.example.av4questao43o.models.Produto;
import com.example.av4questao43o.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EmpresaService empresaService;
    public List<Produto> findAll(Integer id_empresa) {
        Empresa empresa = empresaService.find(id_empresa);
        return produtoRepository.findByEmpresa(empresa);
    }

    public Produto create(Integer id_empresa, Produto produto) {
        Empresa empresa = empresaService.find(id_empresa);
        produto.setEmpresa(empresa);
        return produtoRepository.save(produto);
    }

    public Produto find(Integer id_produto) {
        return produtoRepository.findById(id_produto).orElseThrow(
                () -> new IllegalStateException("Produto nao encontrado. ID:" + id_produto)
        );
    }

    @Transactional
    public Produto update(Integer id_produto, Produto produtoNew) {
        Produto produto = this.find(id_produto);
        produto.setNome(produtoNew.getNome());
        produto.setPreco(produtoNew.getPreco());
        return produto;
    }


    public String destroy(Integer id_produto) {
        Produto produto = this.find(id_produto);
        produtoRepository.delete(produto);
        return "Produto : " + produto.getNome() + " foi Deletado com Sucesso!";
    }
}
