package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    private DentistaRepository dentistaRepository;

    @Autowired
    public DentistaService(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    public Dentista cadastrar(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }


    public Optional<Dentista> buscar(Integer id) {
        return dentistaRepository.findById(id);
    }


    public void excluir(Integer id) {
        dentistaRepository.deleteById(id);
    }


    public List<Dentista> buscarTodos() {
        return dentistaRepository.findAll();
    }


    public Dentista atualizar (Dentista dentista) {
        return dentistaRepository.save(dentista);
    }
}
