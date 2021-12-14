package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Paciente;
import com.digitalhouse.clinicaodonto.repository.PacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;
    Logger logger = Logger.getLogger(PacienteService.class.getName());

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrar(Paciente paciente) {
        logger.debug("Cadastrando paciente");
        return pacienteRepository.save(paciente);
    }


    public Optional<Paciente> buscar(Integer id) {
        logger.debug("Buscando paciente po id");
        return pacienteRepository.findById(id);
    }


    public void excluir(Integer id) {
        logger.debug("Excluindo paciente");
        pacienteRepository.deleteById(id);
    }


    public List<Paciente> buscarTodos() {
        logger.debug("Buscando todos os pacientes");
        return pacienteRepository.findAll();
    }


    public Paciente atualizar (Paciente paciente) {
        logger.debug("Atualizando paciente");
        return pacienteRepository.save(paciente);
    }
}
