package br.com.fiap.tein8.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.tein8.model.Aplicacao;
import br.com.fiap.tein8.repository.AplicacaoRepository;

@Service
public class AplicacaoService {
    
    @Autowired
    AplicacaoRepository repository;

    public Page<Aplicacao> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(Aplicacao aplicacao) {
        repository.save(aplicacao);
    }

    public Optional<Aplicacao> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
