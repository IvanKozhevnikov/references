package ru.demo.references.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demo.references.model.Department;
import ru.demo.references.model.Reference;
import ru.demo.references.repository.ReferenceRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReferenceService {

    private final ReferenceRepository referenceRepository;

    public void create(Reference reference) {
        referenceRepository.save(reference);
    }

    public List<Reference> findAll() {
        return referenceRepository.findAll();
    }

    public Optional<Reference> findById(int id) {
        return referenceRepository.findById(id);
    }

    public boolean update(Reference reference) {
        referenceRepository.save(reference);
        return true;
    }

    public void delete(int id) {
        referenceRepository.deleteById(id);
    }
}
