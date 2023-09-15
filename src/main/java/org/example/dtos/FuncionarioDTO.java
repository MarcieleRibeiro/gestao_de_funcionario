package org.example.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FuncionarioDTO {
    private int id;
    private String nome;

    @JsonProperty("designacao")
    private String designacao;

    private double salario;

    @JsonProperty("numeroTelefone")
    private String numeroTelefone;

    private String endereco;

    public FuncionarioDTO() {
        // Construtor padrão sem argumentos
    }

    @JsonCreator
    public FuncionarioDTO(
            @JsonProperty("id") int id,
            @JsonProperty("nome") String nome,
            @JsonProperty("designacao") String designacao,
            @JsonProperty("salario") double salario,
            @JsonProperty("numeroTelefone") String numeroTelefone,
            @JsonProperty("endereco") String endereco) {
        this.id = id;
        this.nome = nome;
        this.designacao = designacao;
        this.salario = salario;
        this.numeroTelefone = numeroTelefone;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
