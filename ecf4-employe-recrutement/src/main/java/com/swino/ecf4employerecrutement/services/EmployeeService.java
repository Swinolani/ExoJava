package com.swino.ecf4employerecrutement.services;

import com.swino.ecf4employerecrutement.entities.Employee;
import com.swino.ecf4employerecrutement.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> searchEmployeesByName(String name) {
        return employeeRepository.findByEmpNameContaining(name);
    }

    public List<Employee> searchEmployeesByDepartment(Long departmentId) {
        return employeeRepository.findByDepId(departmentId);
    }

    public List<Employee> searchEmployeesByPosition(String position) {
        return employeeRepository.findByEmpPosition(position);
    }
}
