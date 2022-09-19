package br.com.fiap.tein8.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.tein8.model.Aplicacao;
import br.com.fiap.tein8.service.AplicacaoService;

@RestController
@RequestMapping("/api/aplicacao")
public class AplicacaoController {

    @Autowired
    private AplicacaoService service;
    
    @GetMapping
    @Cacheable("aplicacao")
    public Page<Aplicacao> index(@PageableDefault(size = 5) Pageable pageable){
        return service.listAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Aplicacao> create(@RequestBody @Valid Aplicacao aplicacao){
        service.save(aplicacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(aplicacao);
    }

    @GetMapping("{id}")
    public ResponseEntity<Aplicacao> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "aplicacao", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Aplicacao> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Aplicacao> update(@PathVariable Long id, @RequestBody @Valid Aplicacao newAplicacao){
        // buscar a tarefa no BD
        Optional<Aplicacao> optional = service.getById(id);

        // verificar se existe tarefa com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados no objeto
        var aplicacao = optional.get();
        BeanUtils.copyProperties(newAplicacao, aplicacao);
        aplicacao.setId(id);

        // salvar no BD
        service.save(aplicacao);

        return ResponseEntity.ok(aplicacao);
    }
}
