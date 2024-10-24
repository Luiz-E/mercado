package com.luizedu.mercado.controller;

import com.luizedu.mercado.dao.DataValidadeDAO;
import com.luizedu.mercado.dao.ExcluirProdutoDataDAO;
import com.luizedu.mercado.dao.ProdutoPorDataDAO;
import com.luizedu.mercado.model.*;
import com.luizedu.mercado.service.DataProdutoService;
import com.luizedu.mercado.service.ProdutoService;
import com.luizedu.mercado.service.ValidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/validade")
@CrossOrigin(origins = {"http://localhost:5555", "http://10.1.1.38:5555", "http://localhost:4200"}, allowedHeaders = "*", allowCredentials = "true")
public class DataValidadeController {

    @Autowired
    ValidadeService validadeService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    DataProdutoService dataProdutoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoPorDataDAO>> listar() {
        List<ProdutoPorDataDAO> lista = dataProdutoService.listar();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody DataValidadeDAO validadeDao) {

        Optional<DataValidade> dataOptional =  validadeService.buscarPorData(validadeDao.getData());
        Optional<Produto> produtoOptional = produtoService.buscar(validadeDao.getCodigoBarra());
        if (produtoOptional.isEmpty()) {
            return ResponseEntity.status(501).body("O produto não foi encontrado, insira a descrição se quiser criá-lo.");
        }
        DataProduto novaValidade = new DataProduto();
        if (dataOptional.isPresent()) {
            novaValidade.setData(dataOptional.get());
            if (dataProdutoService.buscar(produtoOptional.get(), dataOptional.get()).isPresent()) {
                return ResponseEntity.badRequest().body("Já existe uma validade para este produto nesta data.");
            }
        } else {
            novaValidade.setData(new DataValidade());
            novaValidade.getData().setData(validadeDao.getData());
            validadeService.salvar(novaValidade.getData());
        }
        novaValidade.setDataIncompleta(validadeDao.isDataIncompleta());
        novaValidade.setProduto(produtoOptional.get());
        return ResponseEntity.ok(dataProdutoService.salvar(novaValidade));
    }

    @PostMapping("/excluirProduto")
    public ResponseEntity<?> excluirProduto(@RequestBody ExcluirProdutoDataDAO dao) {
        Optional<DataValidade> validade = validadeService.buscarPorData(dao.getData());
        Optional<Produto> produto = produtoService.buscar(dao.getCodigoBarra());
        if (validade.isPresent() && produto.isPresent()) {
            Optional<DataProduto> data = dataProdutoService.buscar(produto.get(),  validade.get());
            if (data.isPresent()) {
                dataProdutoService.excluir(data.get());
                if (!dataProdutoService.dataExiste(data.get().getData())) {
                    validadeService.excluir(validade.get().getId());
                }
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
