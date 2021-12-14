package com.digitalhouse.clinicaodonto.controller;


import com.digitalhouse.clinicaodonto.model.Paciente;
import com.digitalhouse.clinicaodonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping()
    public ResponseEntity<Paciente> cadastrar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.cadastrar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteService.buscar(id).orElse(null));
    }

    @PutMapping()
    public ResponseEntity<Paciente> atualizar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.cadastrar(paciente));
    }

    @DeleteMapping("/{id}")
    public void excluir (@PathVariable Integer id) {
        pacienteService.excluir(id);
    }

    @GetMapping()
    public ResponseEntity <List<Paciente>> buscarTodos () {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

}
