package com.digitalhouse.clinicaodonto.controller;


import com.digitalhouse.clinicaodonto.model.Consulta;
import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.service.ConsultaService;
import com.digitalhouse.clinicaodonto.service.DentistaService;
import com.digitalhouse.clinicaodonto.service.impl.ConsultaServiceImpl;
import com.digitalhouse.clinicaodonto.service.impl.DentistaServiceImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private ConsultaService consultaService = new ConsultaService(new ConsultaServiceImpl());
    @PostMapping()
    public ResponseEntity<Consulta> cadastrar (@RequestBody Consulta consulta){
        ResponseEntity<Consulta> response = null;
        if (consultaService.buscar(consulta.getDentista().getId()).isPresent() || consultaService.buscar(consulta.getPaciente().getId()).isPresent()){
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.ok(consultaService.cadastrar(consulta));
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscar (@PathVariable Integer id){
        return ResponseEntity.ok(consultaService.buscar(id).orElse(null));
    }

    @PutMapping
    public ResponseEntity<Consulta> atualizar(@RequestBody Consulta consulta){
        ResponseEntity<Consulta> response = null;
        if(consulta.getId() != null && consultaService.buscar(consulta.getId()).isPresent()){
            response = ResponseEntity.ok(consultaService.atualizar(consulta));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir (@PathVariable Integer id){
        ResponseEntity<String> response = null;
        if (consultaService.buscar(id).isPresent()){
            consultaService.excluir(id);
            response= ResponseEntity.status(HttpStatus.NO_CONTENT).body("Consulta excluida com sucesso");
        } else {
          response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return  response;
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> buscarTodos(){
        return ResponseEntity.ok(consultaService.buscarTodos());
    }

}
