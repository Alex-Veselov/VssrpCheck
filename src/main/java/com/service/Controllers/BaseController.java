package com.service.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
public abstract class BaseController<T, ID> {
    protected final JpaRepository<T, ID> repository;

    public BaseController(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T entity) {
        T createdEntity = repository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }

    @GetMapping
    public List<T> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> optionalEntity = repository.findById(id);
        return optionalEntity.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        return repository.findById(id)
                .map(existingEntity -> {
                    BeanUtils.copyProperties(entity, existingEntity, "id");
                    return ResponseEntity.ok(repository.save(existingEntity));
                })
                .orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
