package com.luizedu.app_acougue.controller;

import com.luizedu.app_acougue.model.Produto;
import com.luizedu.app_acougue.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/criarProduto")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        produtoService.salvar(produto);
        return ResponseEntity.ok(produto);
    }
}
