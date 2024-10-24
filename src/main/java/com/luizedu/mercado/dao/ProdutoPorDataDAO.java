package com.luizedu.mercado.dao;

import com.luizedu.mercado.model.Produto;

import java.time.LocalDate;
import java.util.List;

public class ProdutoPorDataDAO {
    private LocalDate data;
    private List<Produto> produtos;

    public ProdutoPorDataDAO(LocalDate data, List<Produto> produtos) {
        this.data = data;
        this.produtos = produtos;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "ProdutoPorDataDAO{" +
                "data=" + data +
                '}';
    }
}
