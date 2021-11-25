package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Consulta;
import com.digitalhouse.clinicaodonto.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta cadastrar(Consulta c) {
        return consultaRepository.save(c);
    }

    public List<Consulta> buscarTodos() {
        return consultaRepository.findAll();
    }

    public void excluir(Integer id) {
        consultaRepository.deleteById(id);
    }

    public Consulta atualizar(Consulta consulta) {
        return null;
    }

    public Optional<Consulta> buscar(Integer id) {
        return consultaRepository.findById(id);
    }
}
