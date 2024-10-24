package com.luizedu.mercado.service;

import com.luizedu.mercado.model.DataValidade;
import com.luizedu.mercado.repository.ValidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ValidadeService {

    @Autowired
    ValidadeRepository validadeRepository;

    public List<DataValidade> listar() {
        return validadeRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
    }

    public DataValidade salvar(DataValidade validade) {
        return validadeRepository.save(validade);
    }

    public Optional<DataValidade> buscarPorData(LocalDate data) {
        return validadeRepository.findByData(data);
    }

    public Optional<DataValidade> buscarPorId(Long validadeId) {
        return validadeRepository.findById(validadeId);
    }

    public void excluir(Long validadeId) {
        validadeRepository.deleteById(validadeId);
    }
}
