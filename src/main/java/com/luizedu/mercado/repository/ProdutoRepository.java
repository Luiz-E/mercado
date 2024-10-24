package com.luizedu.mercado.repository;

import com.luizedu.mercado.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByDescricaoOrCodigoBarras(String descricao, String codigoBarras);
    boolean existsByDescricaoOrCodigoBarras(String descricao, String codigoBarras);
    Optional<Produto> findByCodigoBarras(String codigoBarra);
}
