package ru.demo.references.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demo.references.model.Department;
import ru.demo.references.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public void create(Department department) {
        departmentRepository.save(department);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(int id) {
        return departmentRepository.findById(id);
    }

    public boolean update(Department department) {
        departmentRepository.save(department);
        return true;
    }

    public void delete(int id) {
        departmentRepository.deleteById(id);
    }
}