package com.digitalhouse.clinicaodonto.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private String rg;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro = new Date(System.currentTimeMillis());
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Paciente(Integer id, String nome, String sobrenome, String rg, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
    }

    public Paciente(String nome, String sobrenome, String rg, Date dataCadastro) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.dataCadastro = dataCadastro;
    }

    public Paciente() {
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
