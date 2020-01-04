package com.melissa.pontointeligente.api.repositories;

import com.melissa.pontointeligente.api.entities.Empresa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class EmpresaRepositoryTest {

    @Autowired
    private EmpresaRepository empresaRepository;
    private static final String CNPJ = "82.021.623/0001-05";

    @BeforeEach
    public void setUp() throws Exception {
        Empresa empresa = new Empresa();
        empresa.setCnpj(CNPJ);
        empresa.setRazaoSocial("Empresa exemplo");
        this.empresaRepository.save(empresa);
    }

    @AfterEach
    public final void tearDown() {
        this.empresaRepository.deleteAll();
    }

    @Test
    public void buscaPorCnpj() {
        Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
        assertEquals(empresa.getCnpj(), CNPJ);
    }

}