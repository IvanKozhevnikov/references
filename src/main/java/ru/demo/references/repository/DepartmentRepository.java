package ru.demo.references.repository;

import org.springframework.data.repository.CrudRepository;
import ru.demo.references.model.Department;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    List<Department> findAll();
}