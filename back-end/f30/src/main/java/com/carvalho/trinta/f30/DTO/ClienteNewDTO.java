package com.carvalho.trinta.f30.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class ClienteNewDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    @NotNull(message = "Nome não pode ser nulo")
    @Length(min= 3, max =80, message="O tamanho do nome deve ser entre 3 a 80 caracteres")
    private String nome;
    @NotNull(message = "CPF não pode ser nulo")
    @CPF(message = "formato do CPF está incorreto")
    private String cpf;
    @NotNull(message = "e-mail não pode ser nulo")
    @Email(message = "É necessário registrar um e-mail válido")
    private String email;

    @JsonDeserialize(using =  LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate dataNascimento;

    @NotNull(message = "telefone não pode ser nulo")
    private String telefone1;
    private String telefone2;
    private String telefone3;

    public ClienteNewDTO() {
    }

    public ClienteNewDTO(String nome, String cpf, String email, LocalDate dataNascimento, String telefone1, String telefone2, String telefone3) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }
}
