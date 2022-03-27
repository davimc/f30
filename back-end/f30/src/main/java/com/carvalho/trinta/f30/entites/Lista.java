package com.carvalho.trinta.f30.entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Lista implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Calendar dataPedido;

    @Temporal(TemporalType.DATE)
    private Calendar dataPagamento;

    @Temporal(TemporalType.DATE)
    private Calendar dataEntrega;

    @ManyToOne
    @JoinColumn(name = "lista_cliente")
    private Cliente cliente;

    private Double valor;
    private String formaPagamento;
    private String obs;


    public Lista() {
    }

    public Lista(Calendar dataPedido, Calendar dataPagamento, Calendar dataEntrega, Cliente cliente, Double valor, String formaPagamento, String obs) {
        this.dataPedido = dataPedido;
        this.dataPagamento = dataPagamento;
        this.dataEntrega = dataEntrega;
        this.cliente = cliente;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.obs = obs;
    }

    public Long getId() {
        return id;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Calendar getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Calendar dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
