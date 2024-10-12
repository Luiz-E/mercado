package com.luizedu.app_acougue.service;

import com.luizedu.app_acougue.model.Produto;
import com.luizedu.app_acougue.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

}
