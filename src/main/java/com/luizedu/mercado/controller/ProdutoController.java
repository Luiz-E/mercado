package com.luizedu.mercado.controller;

import com.luizedu.mercado.model.Produto;
import com.luizedu.mercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = {"http://localhost:5555", "http://10.1.1.38:5555", "http://localhost:4200"}, allowedHeaders = "*", allowCredentials = "true")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("listar")
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> lista = produtoService.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/buscarProduto/{produtoId}")
    public ResponseEntity<?> buscar(@PathVariable Long produtoId) {
        Optional<Produto> produto = produtoService.buscar(produtoId);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto);
        }

        return ResponseEntity.badRequest().body("Nenhum produto encontrado.");
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody Produto produto) {
        try {
            Produto novoProduto = produtoService.salvar(produto);
            return ResponseEntity.ok(novoProduto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o produto: " + e.getMessage());
        }
    }

    @PutMapping("/atualizar/{produtoId}")
    public ResponseEntity<?> atualizar(@PathVariable Long produtoId, @RequestBody Produto produtoNovo) {
        Optional<Produto> produto = produtoService.buscar(produtoNovo.getCodigoBarras(), produtoNovo.getDescricao());
        if (produto.isPresent() && !Objects.equals(produto.get().getId(), produtoId)) {
            return ResponseEntity.badRequest().body("Produto já existente.");
        }
        Produto produtoAtualizado = produtoService.atualizar(produtoId, produtoNovo);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/deletar/{produtoId}")
    public ResponseEntity<Void> deletar(@PathVariable Long produtoId) {
        produtoService.deletar(produtoId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletarTodos/{produtoId}")
    public ResponseEntity<Void> deletarTodos(@PathVariable Long produtoId) {
        produtoService.deletarTodos(produtoId);
        return ResponseEntity.noContent().build();
    }
}
