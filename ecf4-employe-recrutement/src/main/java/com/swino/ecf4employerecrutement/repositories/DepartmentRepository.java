package com.swino.ecf4employerecrutement.repositories;

import com.swino.ecf4employerecrutement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
