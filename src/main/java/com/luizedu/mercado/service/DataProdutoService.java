package com.luizedu.mercado.service;

import com.luizedu.mercado.model.DataProduto;
import com.luizedu.mercado.model.DataValidade;
import com.luizedu.mercado.model.Produto;
import com.luizedu.mercado.dao.ProdutoPorDataDAO;
import com.luizedu.mercado.repository.DataProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DataProdutoService {

    @Autowired
    DataProdutoRepository repository;

    public DataProduto salvar(DataProduto dataProduto) {
        return repository.save(dataProduto);
    }

    public Optional<DataProduto> buscar(Produto produtoId, DataValidade dataId) {
        return repository.findByDataAndProduto(dataId, produtoId);
    }

    public void excluir(DataProduto dataProduto) {
        repository.delete(dataProduto);
    }

    public List<ProdutoPorDataDAO> listar() {
        List<DataProduto> datas = repository.findAll();
        Map<LocalDate, List<Produto>> mapa = new HashMap<>();

        for (DataProduto dataProduto : datas) {
            if (mapa.containsKey(dataProduto.getData().getData())) {
                mapa.get(dataProduto.getData().getData()).add(dataProduto.getProduto());
            } else {
                mapa.put(dataProduto.getData().getData(), new ArrayList<>(List.of(dataProduto.getProduto())));
            }
        }
        List<ProdutoPorDataDAO> resultado = new ArrayList<>();
        mapa.forEach((LocalDate data, List<Produto> lista) -> {
            resultado.add(new ProdutoPorDataDAO(data, lista));
        });
        resultado.sort(Comparator.comparing(ProdutoPorDataDAO::getData));
        return resultado;
    }

    public boolean dataExiste(DataValidade data) {
        return repository.existsByData(data);
    }
}
