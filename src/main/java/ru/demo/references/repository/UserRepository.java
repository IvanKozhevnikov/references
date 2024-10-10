package ru.demo.references.repository;

import org.springframework.data.repository.CrudRepository;
import ru.demo.references.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsernameAndPassword(String username, String password);
}
