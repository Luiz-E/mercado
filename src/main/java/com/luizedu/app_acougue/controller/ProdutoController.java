package com.luizedu.app_acougue.controller;

import com.luizedu.app_acougue.model.Produto;
import com.luizedu.app_acougue.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/criarProduto")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvar(produto);
        return ResponseEntity.ok(novoProduto);
    }

    @PutMapping("/update/{produtoId}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long produtoId, @RequestBody Produto produtoNovo) {
        Produto produtoAtualizado = produtoService.atualizar(produtoId, produtoNovo);
        return ResponseEntity.ok(produtoAtualizado);
    }
}
