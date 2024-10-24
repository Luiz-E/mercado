package com.luizedu.mercado.model;

import jakarta.persistence.*;

@Entity
@Table(name="data_produto")
@IdClass(DataProdutoId.class)
public class DataProduto {

    @Id
    @ManyToOne
    @JoinColumn(name = "data_id")
    private DataValidade data;

    @Id
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private boolean dataIncompleta;

    public DataValidade getData() {
        return data;
    }

    public Produto getProduto() {
        return produto;
    }

    public boolean isDataIncompleta() {
        return dataIncompleta;
    }

    public DataProduto() {}

    public DataProduto(DataValidade data, Produto produto, boolean dataCompleta) {
        this.data = data;
        this.produto = produto;
        this.dataIncompleta = dataCompleta;
    }

    public void setData(DataValidade data) {
        this.data = data;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setDataIncompleta(boolean dataIncompleta) {
        this.dataIncompleta = dataIncompleta;
    }

    @Override
    public String toString() {
        return "DataProduto{" +
                ", data=" + data +
                ", produto=" + produto +
                ", dataCompleta=" + dataIncompleta +
                '}';
    }
}
