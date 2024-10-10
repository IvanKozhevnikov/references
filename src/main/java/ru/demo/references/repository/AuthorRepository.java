package ru.demo.references.repository;

import org.springframework.data.repository.CrudRepository;
import ru.demo.references.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Author findByAuthority(String authority);
}
