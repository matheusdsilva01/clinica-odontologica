package com.digitalhouse.clinicaodonto.repository;

import com.digitalhouse.clinicaodonto.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    //Metodos de cadastrar paciente, buscar, buscar todos, buscar por id e atualizar
}
