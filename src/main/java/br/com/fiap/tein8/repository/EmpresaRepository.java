package br.com.fiap.tein8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.tein8.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    
}