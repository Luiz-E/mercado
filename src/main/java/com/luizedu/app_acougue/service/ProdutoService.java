package com.luizedu.app_acougue.service;

import com.luizedu.app_acougue.model.Produto;
import com.luizedu.app_acougue.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;



    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long produtoId, Produto produto) {
        Produto produtoExistente = produtoRepository
                .findById(produtoId)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));

        produtoExistente.setDescricao(produto.getDescricao());
        return produtoRepository.save(produtoExistente);
    }

}
