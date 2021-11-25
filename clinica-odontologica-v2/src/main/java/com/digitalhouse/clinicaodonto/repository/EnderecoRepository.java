package com.digitalhouse.clinicaodonto.repository;

import com.digitalhouse.clinicaodonto.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    // Cadastrar endereco, buscar, buscar por id, buscar todos e excluir endereco
}
