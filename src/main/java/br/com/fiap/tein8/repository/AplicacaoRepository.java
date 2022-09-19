package br.com.fiap.tein8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.tein8.model.Aplicacao;

public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long> {

    
}