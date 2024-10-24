package com.luizedu.mercado.repository;

import com.luizedu.mercado.model.DataProduto;
import com.luizedu.mercado.model.DataValidade;
import com.luizedu.mercado.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DataProdutoRepository extends JpaRepository<DataProduto, Long> {

    Optional<DataProduto> findByDataAndProduto(DataValidade data, Produto produto);

    boolean existsByData(DataValidade data);
    List<DataProduto> findAllByProduto(Produto produto);
}
