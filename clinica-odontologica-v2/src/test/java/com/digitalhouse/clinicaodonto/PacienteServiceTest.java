package com.digitalhouse.clinicaodonto;

import com.digitalhouse.clinicaodonto.model.Paciente;
import com.digitalhouse.clinicaodonto.service.PacienteService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;

    @Test
    public void cadastrarPaciente() {
        Paciente paciente = new Paciente("Matheus","Silva","54186", new Date());
        pacienteService.cadastrar(paciente);
        Assert.assertNotNull(pacienteService.buscar(1));
    }

    @Test
    public void buscarPacientePorId() {
        Assert.assertNotNull(pacienteService.buscar(1));
    }

    @Test
    public void buscarTodosPacientes() {
        Assert.assertNotNull(pacienteService.buscarTodos());
    }

    @Test
    public void excluirPaciente() {
        pacienteService.excluir(1);
        Assert.assertTrue(pacienteService.buscar(1).isEmpty());
    }
}
