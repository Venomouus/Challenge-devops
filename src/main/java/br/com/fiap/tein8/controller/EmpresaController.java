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

import br.com.fiap.tein8.model.Empresa;
import br.com.fiap.tein8.service.EmpresaService;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService service;
    
    @GetMapping
    @Cacheable("empresa")
    public Page<Empresa> index(@PageableDefault(size = 5) Pageable pageable){
        return service.listAll(pageable);
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody @Valid Empresa empresa){
        service.save(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> show(@PathVariable Long id){
        return ResponseEntity.of(service.getById(id));
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "empresa", allEntries = true)
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Empresa> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Empresa> update(@PathVariable Long id, @RequestBody @Valid Empresa newEmpresa){
        // buscar a tarefa no BD
        Optional<Empresa> optional = service.getById(id);

        // verificar se existe tarefa com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados no objeto
        var empresa = optional.get();
        BeanUtils.copyProperties(newEmpresa, empresa);
        empresa.setId(id);

        // salvar no BD
        service.save(empresa);

        return ResponseEntity.ok(empresa);
    }
}
