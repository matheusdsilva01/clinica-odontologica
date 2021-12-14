package com.digitalhouse.clinicaodonto.controller;

import com.digitalhouse.clinicaodonto.model.Endereco;
import com.digitalhouse.clinicaodonto.repository.EnderecoRepository;
import com.digitalhouse.clinicaodonto.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity <List<Endereco>> getAllEndereco(){
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }
}
