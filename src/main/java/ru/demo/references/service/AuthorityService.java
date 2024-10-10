package ru.demo.references.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.demo.references.model.Authority;
import ru.demo.references.repository.AuthorityRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    private static final Logger LOG = LoggerFactory.getLogger(AuthorityService.class.getName());

    public Optional<Authority> save(Authority authority) {
        Optional<Authority> rsl = Optional.empty();
        try {
            rsl = Optional.of(authorityRepository.save(authority));
        } catch (Exception e) {
            LOG.error("Error!", e);
        }
        return rsl;
    }
}
