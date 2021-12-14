package com.digitalhouse.clinicaodonto;

import com.digitalhouse.clinicaodonto.model.Consulta;
import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.model.Paciente;
import com.digitalhouse.clinicaodonto.service.ConsultaService;
import com.digitalhouse.clinicaodonto.service.DentistaService;
import com.digitalhouse.clinicaodonto.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsultaServiceTest {
    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DentistaService dentistaService;

    @Test
    public void cadastrarTest() {
        Paciente paciente = new Paciente("Ricardo", "Olavio","68522", new Date());
        Dentista dentista = new Dentista("João", "Pereira",31684, null);
        consultaService.cadastrar(new Consulta(paciente ,dentista, new Date()));
        Assert.assertNotNull(consultaService.buscar(1));
    }

    @Test
    public void buscarTodasAsConsultas() {
        Assert.assertNotNull(consultaService.buscarTodos());
    }


    @Test
    public void excluirConsultas() {
        consultaService.excluir(1);
        Assert.assertTrue(consultaService.buscar(1).isEmpty());
    }

}
