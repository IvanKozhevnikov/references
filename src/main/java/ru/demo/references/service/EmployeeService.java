package ru.demo.references.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demo.references.model.Employee;
import ru.demo.references.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public boolean update(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }
}
