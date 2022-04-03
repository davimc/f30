package com.carvalho.trinta.f30.DTO;

import com.carvalho.trinta.f30.domains.Cliente;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String telefone;

    @Temporal(TemporalType.DATE)
    private Calendar dataCadastro;
    @Temporal(TemporalType.DATE)
    private Calendar dataNascimento;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.dataCadastro = cliente.getDataCadastro();
        this.dataNascimento = cliente.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
