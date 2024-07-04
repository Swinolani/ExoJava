package com.swino.ecf4employerecrutement.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String empName;
    private String empPosition;

    @ManyToOne
    @JoinColumn(name = "depId")
    private Department empDepartment;
}