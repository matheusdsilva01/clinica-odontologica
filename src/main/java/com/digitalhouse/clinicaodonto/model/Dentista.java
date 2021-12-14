package com.digitalhouse.clinicaodonto.model;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "tb_dentista")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer matricula;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Dentista(Integer id, String nome, String sobrenome, Integer matricula, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.endereco = endereco;
    }

    public Dentista(String nome, String sobrenome, Integer matricula, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.endereco = endereco;
    }

    public Dentista() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
