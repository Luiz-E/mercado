package com.luizedu.app_acougue.controller;

import com.luizedu.app_acougue.model.Produto;
import com.luizedu.app_acougue.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = {"http://localhost:5555", "http://10.1.1.38:5555"}, allowedHeaders = "*", allowCredentials = "true")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("listar")
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> lista = produtoService.listar();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
        System.out.println(produto);
        Produto novoProduto = produtoService.salvar(produto);
        return ResponseEntity.ok(novoProduto);
    }

    @PutMapping("/atualizar/{produtoId}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long produtoId, @RequestBody Produto produtoNovo) {
        Produto produtoAtualizado = produtoService.atualizar(produtoId, produtoNovo);
        System.out.println(produtoNovo);
        System.out.println(produtoAtualizado);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/deletar/{produtoId}")
    public ResponseEntity<Void> deletar(@PathVariable Long produtoId) {
        produtoService.deletar(produtoId);
        return ResponseEntity.noContent().build();
    }
}
