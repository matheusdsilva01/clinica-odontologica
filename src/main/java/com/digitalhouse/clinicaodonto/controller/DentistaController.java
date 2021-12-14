package com.digitalhouse.clinicaodonto.controller;


import com.digitalhouse.clinicaodonto.exception.ResourceNotFoundException;
import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    private DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping()
    public ResponseEntity<Dentista> cadastrar(@RequestBody Dentista dentista) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistaService.cadastrar(dentista));
    }

    @GetMapping()
    public ResponseEntity <List<Dentista>> buscarTodos () {
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(dentistaService.buscar(id).orElse(null));
    }

    @PutMapping()
    public ResponseEntity<Dentista> atualizar(@RequestBody Dentista dentista) {
        return ResponseEntity.ok(dentistaService.cadastrar(dentista));
    }

    @DeleteMapping("/{id}")
    public void excluir (@PathVariable Integer id) throws ResourceNotFoundException {
        dentistaService.excluir(id);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processarBadRequestException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


}
