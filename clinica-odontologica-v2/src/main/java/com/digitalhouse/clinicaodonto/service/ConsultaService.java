package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Consulta;
import com.digitalhouse.clinicaodonto.repository.ConsultaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private ConsultaRepository consultaRepository;
    Logger logger = Logger.getLogger(ConsultaService.class.getName());
    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta cadastrar(Consulta c) {
        logger.debug("Cadastrando consulta");
        return consultaRepository.save(c);
    }

    public List<Consulta> buscarTodos() {
        logger.debug("Buscando todas as consultas");
        return consultaRepository.findAll();
    }

    public void excluir(Integer id) {
        logger.debug("Excluindo consulta");
        consultaRepository.deleteById(id);
    }

    public Consulta atualizar(Consulta consulta) {
        logger.debug("Atualizando consulta");
        return consultaRepository.save(consulta);
    }

    public Optional<Consulta> buscar(Integer id) {
        logger.debug("Buscando consulta por id");
        return consultaRepository.findById(id);
    }
}
