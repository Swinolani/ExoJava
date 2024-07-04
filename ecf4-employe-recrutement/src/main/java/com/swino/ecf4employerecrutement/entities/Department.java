package com.swino.ecf4employerecrutement.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depId;

    private String depName;

    @OneToMany(mappedBy = "empDepartment")
    private List<Employee> depEmployees;
}
