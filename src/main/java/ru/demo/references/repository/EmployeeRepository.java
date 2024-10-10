package ru.demo.references.repository;

import org.springframework.data.repository.CrudRepository;
import ru.demo.references.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findAll();
}