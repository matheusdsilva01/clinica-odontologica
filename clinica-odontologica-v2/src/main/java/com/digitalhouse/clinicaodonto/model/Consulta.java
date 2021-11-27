package com.digitalhouse.clinicaodonto.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Paciente paciente;
    @OneToOne(cascade = CascadeType.ALL)
    private Dentista dentista;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date(System.currentTimeMillis());

    public Consulta(Integer id, Paciente paciente, Dentista dentista, Date date) {
        this.id = id;
        this.paciente = paciente;
        this.dentista = dentista;
        this.date = date;
    }

    public Consulta(Paciente paciente, Dentista dentista, Date date) {
        this.paciente = paciente;
        this.dentista = dentista;
        this.date = date;
    }

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
