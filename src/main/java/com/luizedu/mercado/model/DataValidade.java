package com.luizedu.mercado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="DataValidade")
public class DataValidade {

    @Id
    @Column(name = "data_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data")
    private LocalDate data;

    @JsonIgnore
    @OneToMany(mappedBy = "data")
    private Set<DataProduto> dataProdutos;

    public DataValidade() {}

    public DataValidade(LocalDate data, boolean dataIncompleta, Set<DataProduto> dataProdutos) {
        this.data = data;
        this.dataProdutos = dataProdutos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Set<DataProduto> getDataProdutos() {
        return dataProdutos;
    }

    public void setDataProdutos(Set<DataProduto> dataProdutos) {
        this.dataProdutos = dataProdutos;
    }
}
