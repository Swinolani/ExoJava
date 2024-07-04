package com.swino.ecf4employerecrutement.repositories;

import com.swino.ecf4employerecrutement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmpNameContaining(String empName);

    List<Employee> findByDepId(Long depId);

    List<Employee> findByEmpPosition(String empPosition);

}
