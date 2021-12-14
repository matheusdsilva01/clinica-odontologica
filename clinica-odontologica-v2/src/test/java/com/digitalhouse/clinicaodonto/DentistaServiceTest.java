package com.digitalhouse.clinicaodonto;

import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.model.Endereco;
import com.digitalhouse.clinicaodonto.service.DentistaService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DentistaServiceTest {

    @Autowired
    DentistaService dentistaService;


    @Test
    public void cadastrarDentista() {
        Dentista dentista = new Dentista("matheus", "silva", 1, new Endereco("rua","48","cidade","estado"));
        dentistaService.cadastrar(dentista);
        Assert.assertNotNull(dentistaService.buscar(1));
    }

    @Test
    public void listarTodosOsDentistas() {
        Assert.assertNotNull(dentistaService.buscarTodos());
    }

    @Test
    public void buscarDentistaPorId() {
        Assert.assertTrue(dentistaService.buscar(1).isEmpty());
    }

//    @Test
//    public void deletarDentista() {
//        dentistaService.excluir(1);
//        Assert.assertTrue(dentistaService.buscar(1).isEmpty());
//    }
}
