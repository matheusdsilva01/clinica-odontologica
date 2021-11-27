package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.repository.DentistaRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DentistaService {

    private DentistaRepository dentistaRepository;
    Logger logger = Logger.getLogger(DentistaService.class.getName());

    @Autowired
    public DentistaService(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    public Dentista cadastrar(Dentista dentista) {
        logger.debug("Cadastrando dentista");
        return dentistaRepository.save(dentista);
    }


    public Optional<Dentista> buscar(Integer id) {
        logger.debug("Buscando dentista por id");
        return dentistaRepository.findById(id);
    }


    public void excluir(Integer id) {
        logger.debug("Excluindo dentista");
        dentistaRepository.deleteById(id);
    }


    public List<Dentista> buscarTodos() {
        logger.debug("Buscando todos os dentistas");
        return dentistaRepository.findAll();
    }


    public Dentista atualizar (Dentista dentista) {
        logger.debug("Atualizando dentista");
        return dentistaRepository.save(dentista);
    }
}
