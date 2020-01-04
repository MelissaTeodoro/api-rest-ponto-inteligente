package com.melissa.pontointeligente.api.repositories;

import com.melissa.pontointeligente.api.entities.Empresa;
import com.melissa.pontointeligente.api.entities.Funcionario;
import com.melissa.pontointeligente.api.enums.PerfilEnum;
import com.melissa.pontointeligente.api.utils.PasswordUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class FuncionarioRepositoryTest {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    private static final String EMAIL = "email@email.com";
    private static final String CPF = "24291173474";

    @BeforeEach
    public void setUp() throws Exception {

        Empresa empresa = obterDadosEmpresa();
        this.funcionarioRepository.save(obterDadosFuncionario(empresa));
    }

    @AfterEach
    public final void tearDown() {
        this.funcionarioRepository.deleteAll();
    }

    @Test
    public void testBuscarFuncionarioPorEmail() {
        Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
        assertEquals(funcionario.getEmail(), EMAIL);
    }

    @Test
    public void testBuscarFuncionarioPorCpf() {
        Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
        assertEquals(funcionario.getCpf(), CPF);
    }

    @Test
    public void testBuscarFuncionarioPorEmailECpf() {
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);
        assertEquals(funcionario.getEmail(), EMAIL);
        assertEquals(funcionario.getCpf(), CPF);
    }

    @Test
    public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {
        String emailInvalid = "email@invalid.com";
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, emailInvalid);
        assertNotEquals(emailInvalid, funcionario.getEmail());
    }

    @Test
    public void testBuscarFuncionarioPorEmailECpfParaCpfInvalido() {
        String cpfInvalid = "12212211212";
        Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, cpfInvalid);
        assertNotEquals(cpfInvalid, funcionario.getCpf());
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