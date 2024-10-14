package ru.demo.references.repository;

import org.springframework.data.repository.CrudRepository;
import ru.demo.references.model.Reference;

import java.util.List;

public interface ReferenceRepository extends CrudRepository<Reference, Integer> {

    List<Reference> findAll();
}
