package com.luizedu.mercado.service;

import com.luizedu.mercado.model.DataProduto;
import com.luizedu.mercado.model.Produto;
import com.luizedu.mercado.repository.DataProdutoRepository;
import com.luizedu.mercado.repository.ProdutoRepository;
import com.luizedu.mercado.repository.ValidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private DataProdutoRepository dataProdutoRepository;
    @Autowired
    private ValidadeRepository validadeRepository;

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto) {
        Optional<Produto> produtoOptional = produtoRepository.findByDescricaoOrCodigoBarras(produto.getDescricao(), produto.getCodigoBarras());
        if (produtoOptional.isPresent()) {
            Produto produtoExistente = produtoOptional.get();
            if (produto.getDescricao().equalsIgnoreCase(produtoExistente.getDescricao())) {
                throw new IllegalArgumentException("O produto com código " + produtoExistente.getCodigoBarras() + " já possui essa descrição.");
            } else if (produto.getCodigoBarras().equalsIgnoreCase(produtoExistente.getCodigoBarras())) {
                throw new IllegalArgumentException("O produto " + produtoExistente.getDescricao() + " já possui esse código de barras.");
            } else {
                throw new IllegalArgumentException("Esse produto já existe ou um erro similar ocorreu.");
            }
        }
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long produtoId, Produto produto) {
        Produto produtoExistente = produtoRepository
                .findById(produtoId)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));

        produtoExistente.setDescricao(produto.getDescricao());
        produtoExistente.setCodigoBarras(produto.getCodigoBarras());
        return produtoRepository.save(produtoExistente);
    }

    public void deletar(Long produtoId) {
        produtoRepository
                .findById(produtoId)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado."));
        produtoRepository.deleteById(produtoId);
    }

    public Optional<Produto> buscar(Long produtoId) {
        return produtoRepository.findById(produtoId);
    }

    public Optional<Produto> buscar(String codigoBarra) {
        return produtoRepository.findByCodigoBarras(codigoBarra);
    }

    public Optional<Produto> buscar(String codigoBarras, String descricao) {
        return produtoRepository.findByDescricaoOrCodigoBarras(descricao, codigoBarras);
    }

    public void deletarTodos(Long produtoId) {
        Optional<Produto> produto = produtoRepository.findById(produtoId);
        if (produto.isPresent()) {
            List<DataProduto> vencimentos = dataProdutoRepository.findAllByProduto(produto.get());
            vencimentos.forEach(vencimento -> {
                dataProdutoRepository.delete(vencimento);
                if (!dataProdutoRepository.existsByData(vencimento.getData())) {
                    validadeRepository.deleteById(vencimento.getData().getId());
                }
            });
            deletar(produtoId);
        }
    }
}
