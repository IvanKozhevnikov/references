package ru.demo.references.repository;

import org.springframework.data.repository.CrudRepository;
import ru.demo.references.model.Authority;

import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Optional<Authority> findByAuthority(String authority);

}