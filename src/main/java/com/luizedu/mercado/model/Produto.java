package com.luizedu.mercado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="Produto")
public class Produto {

    @Id
    @Column(name = "produto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "codigo")
    private String codigoBarras;

    @OneToMany(mappedBy = "produto")
    private Set<LoteProduto> loteProdutos;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private Set<DataProduto> dataProdutos;

    public Produto(String descricao, String codigoBarras, Set<LoteProduto> loteProdutos, Set<DataProduto> dataProdutos) {
        this.descricao = descricao;
        this.codigoBarras = codigoBarras;
        this.loteProdutos = loteProdutos;
        this.dataProdutos = dataProdutos;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Set<LoteProduto> getLoteProdutos() {
        return loteProdutos;
    }

    public void setLoteProdutos(Set<LoteProduto> loteProdutos) {
        this.loteProdutos = loteProdutos;
    }

    public Set<DataProduto> getDataProdutos() {
        return dataProdutos;
    }

    public void setDataProdutos(Set<DataProduto> dataProdutos) {
        this.dataProdutos = dataProdutos;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", loteProdutos=" + loteProdutos +
                ", dataProdutos=" + dataProdutos +
                '}';
    }
}