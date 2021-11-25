package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.model.Endereco;
import com.digitalhouse.clinicaodonto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService{

    private EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public ResponseEntity<Endereco> cadastrar(Endereco endereco) {
        return ResponseEntity.ok(enderecoRepository.save(endereco));
    }

    public ResponseEntity<Optional<Endereco>> buscar(Integer id) {
            return ResponseEntity.ok(enderecoRepository.findById(id));
    }


    public void excluir(Integer id) {
        enderecoRepository.deleteById(id);
    }

    public ResponseEntity<List<Endereco>> buscarTodos() {
        return ResponseEntity.ok(enderecoRepository.findAll());
    }

    public ResponseEntity<Endereco> atualizar (Endereco endereco){
        return ResponseEntity.ok(enderecoRepository.save(endereco));
    }

}
