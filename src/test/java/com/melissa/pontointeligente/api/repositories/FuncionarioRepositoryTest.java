package com.melissa.pontointeligente.api.repositories;

import com.melissa.pontointeligente.api.entities.Empresa;
import com.melissa.pontointeligente.api.entities.Funcionario;
import com.melissa.pontointeligente.api.enums.PerfilEnum;
import com.melissa.pontointeligente.api.utils.PasswordUtils;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private static final String EMAIL = "email@email.com";
    private static final String CPF = "24291173474";

    @BeforeEach
    public void setUp() throws Exception {

    }

    @AfterEach
    public final void tearDown() {
    }

    @Test
    public void testBuscarFuncionarioPorEmail() {

    }

    @Test
    public void testBuscarFuncionarioPorCpf() {
    }

    @Test
    public void testBuscarFuncionarioPorEmailECpf() {

    }

    @Test
    public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {

    }

    @Test
    public void testBuscarFuncionarioPorEmailECpfParaCpfInvalido() {

    }

    private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Fulano de Tal");
        funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
        funcionario.setSenha(PasswordUtils.gerarBCrypt("123456"));
        funcionario.setCpf(CPF);
        funcionario.setEmail(EMAIL);
        funcionario.setEmpresa(empresa);
        return funcionario;
    }

    private Empresa obterDadosEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial("Empresa de exemplo");
        empresa.setCnpj("82.021.623/0001-05");
        return empresa;
    }

}