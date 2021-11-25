package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Paciente;
import com.digitalhouse.clinicaodonto.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }


    public Optional<Paciente> buscar(Integer id) {
        return pacienteRepository.findById(id);
    }


    public void excluir(Integer id) {
        pacienteRepository.deleteById(id);
    }


    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }


    public Paciente atualizar (Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}
