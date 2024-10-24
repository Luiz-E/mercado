package com.luizedu.mercado.repository;

import com.luizedu.mercado.model.DataValidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ValidadeRepository extends JpaRepository<DataValidade, Long> {
    Optional<DataValidade> findByData(LocalDate data);
}
