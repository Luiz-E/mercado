package com.luizedu.app_acougue.model;

import jakarta.persistence.*;

@Entity
@Table(name="lote_produto")
public class LoteProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantity;

    public Long getId() {
        return id;
    }

    public Lote getLote() {
        return lote;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantity() {
        return quantity;
    }

    public LoteProduto() {}
    public LoteProduto(Long id, Lote lote, Produto produto, int quantity) {
        this.id = id;
        this.lote = lote;
        this.produto = produto;
        this.quantity = quantity;
    }
}
