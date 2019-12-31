package com.melissa.pontointeligente.api.repositories;

import com.melissa.pontointeligente.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Transactional
    Empresa findByCnpj(String cnpj);
}
