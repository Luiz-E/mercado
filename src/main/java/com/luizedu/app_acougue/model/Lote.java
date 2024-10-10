package com.luizedu.app_acougue.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Lote")
public class Lote {

    @Id
    @Column(name="lote_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;


//    @JoinTable(
//            name="Lote_Produto",
//            joinColumns = {@JoinColumn(name = "lote_id")},
//            inverseJoinColumns = { @JoinColumn(name = "produto_id") }
//    )
//    Set<Produto> produtos = new HashSet<>();

    @OneToMany(mappedBy = "lote")
    private Set<LoteProduto> loteProdutos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Lote() {}
    public Lote(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Lote lote = (Lote) object;
        return Objects.equals(id, lote.id) && Objects.equals(nome, lote.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
