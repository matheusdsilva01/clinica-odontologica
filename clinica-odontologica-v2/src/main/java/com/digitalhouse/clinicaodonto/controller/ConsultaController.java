package com.digitalhouse.clinicaodonto.controller;


import com.digitalhouse.clinicaodonto.model.Consulta;
import com.digitalhouse.clinicaodonto.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    public ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping()
    public ResponseEntity<Consulta> cadastrar (@RequestBody Consulta consulta){
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.cadastrar(consulta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Consulta>> buscar (@PathVariable Integer id){
        return ResponseEntity.ok(consultaService.buscar(id));
    }


    // falta isso aqui pra baixo
    @PutMapping()
    public ResponseEntity<Consulta> atualizar(@RequestBody Consulta consulta){
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(consultaService.cadastrar(consulta));
    }

    @DeleteMapping("/{id}")
    public void excluir (@PathVariable Integer id){
        consultaService.excluir(id);
    }

    @GetMapping()
    public ResponseEntity<List<Consulta>> buscarTodos(){
        return ResponseEntity.ok(consultaService.buscarTodos());
    }

}
