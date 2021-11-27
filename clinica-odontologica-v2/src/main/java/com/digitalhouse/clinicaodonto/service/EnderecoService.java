package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Endereco;
import com.digitalhouse.clinicaodonto.repository.EnderecoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService{

    private EnderecoRepository enderecoRepository;
    Logger logger = Logger.getLogger(EnderecoService.class.getName());

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco cadastrar(Endereco endereco) {
        logger.debug("Cadastrando endereço");
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> buscar(Integer id) {
        logger.debug("Buscando endereço po id");
        return enderecoRepository.findById(id);
    }


    public void excluir(Integer id) {
        logger.debug("Excluindo endereço");
        enderecoRepository.deleteById(id);
    }

    public List<Endereco> buscarTodos() {
        logger.debug("Buscando todos os endereços");
        return enderecoRepository.findAll();
    }

    public Endereco atualizar (Endereco endereco){
        logger.debug("Atualizando endereço");
        return enderecoRepository.save(endereco);
    }

}
