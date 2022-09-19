package br.com.fiap.tein8.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.tein8.model.Empresa;
import br.com.fiap.tein8.repository.EmpresaRepository;

@Service
public class EmpresaService {
    
    @Autowired
    EmpresaRepository repository;

    public Page<Empresa> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(Empresa empresa) {
        repository.save(empresa);
    }

    public Optional<Empresa> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
