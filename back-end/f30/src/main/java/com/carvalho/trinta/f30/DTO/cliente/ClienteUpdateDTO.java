package com.carvalho.trinta.f30.DTO.cliente;

import com.carvalho.trinta.f30.domains.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ClienteUpdateDTO {
    @NotBlank(message = "Nome não pode ser vazio")
    @Length(min= 3, max =80, message="O tamanho do nome deve ser entre 3 a 80 caracteres")
    private String nome;

    @Email(message = "Formato de e-mail incorreto")
    @NotBlank(message = "Email não pode ser email")
    private String email;


    @JsonDeserialize(using =  LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy/MM/dd")
    @NotNull(message = "Data de nascimento precisa ser informada")
    private LocalDate dataNascimento;

    @NotBlank(message = "telefone não pode ficar vazio")
    private String telefone1;
    private String telefone2;
    private String telefone3;

    public ClienteUpdateDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public static Cliente update(Cliente obj, ClienteUpdateDTO objDTO) {
        obj.setNome(objDTO.getNome());
        obj.setEmail(objDTO.getEmail());
        obj.setDataNascimento(objDTO.getDataNascimento());
        obj.getTelefone().clear();
        obj.getTelefone().add(objDTO.telefone1);
        if(!(objDTO.getTelefone2() == null ||objDTO.getTelefone2().equals("") )) obj.getTelefone().add(objDTO.getTelefone2());
        if(!(objDTO.getTelefone3() == null || objDTO.getTelefone3().equals("") )) obj.getTelefone().add(objDTO.getTelefone3());

        return obj;
    }
}
