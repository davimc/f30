package com.carvalho.trinta.f30.DTO;

import com.carvalho.trinta.f30.domains.Cliente;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ClienteDTO {
    private Long id;
    @NotNull(message = "Nome não pode ser nulo")
    @Length(min= 3, max =80, message="O tamanho do nome deve ser entre 3 a 80 caracteres")
    private String nome;
    @NotNull(message = "CPF não pode ser nulo")
    @CPF(message = "formato do CPF está incorreto")
    private String cpf;

    @NotNull(message = "e-mail não pode ser nulo")
    @Email(message = "É necessário registrar um e-mail válido")
    private String email;

    @NotNull(message = "Data de cadastro precisa ser informada")
    @Temporal(TemporalType.DATE)
    private LocalDate dataCadastro;


    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

    @NotEmpty(message = "Você precisa informar ao menos um telefone para contato")
    private Set<String> telefone = new HashSet<>();

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataCadastro = cliente.getDataCadastro();
        this.dataNascimento = cliente.getDataNascimento();
        this.telefone = cliente.getTelefone();
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

    public Set<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<String> telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
