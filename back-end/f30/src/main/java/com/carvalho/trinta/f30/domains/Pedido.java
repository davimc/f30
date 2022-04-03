package com.carvalho.trinta.f30.domains;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pedido implements Serializable {
    private static final long serialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pedido_produto")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "pedido_lista")
    private Lista lista;

    private Integer qtd;
    //quanto estava o preço no dia
    private Double precoDia;


    public Pedido() {
    }

    public Pedido(Produto produto, Lista lista, Integer qtd, Double precoDia) {
        this.produto = produto;
        this.lista = lista;
        this.qtd = qtd;
        this.precoDia = precoDia;
    }

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getPrecoDia() {
        return precoDia;
    }

    public void setPrecoDia(Double precoDia) {
        this.precoDia = precoDia;
    }
}
