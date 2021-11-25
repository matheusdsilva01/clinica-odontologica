package com.digitalhouse.clinicaodonto.repository;

import com.digitalhouse.clinicaodonto.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Integer>{

}
