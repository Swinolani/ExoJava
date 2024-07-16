package com.swino.trainingrest.entity.exoEmploye;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String identificationNumber;
    private String address;
    private String phone;
    private String email;
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;
    @Temporal(TemporalType.DATE)
    private LocalDate contractStart;
    @Temporal(TemporalType.DATE)
    private LocalDate contractEnd;
    private String occupation;
    private String password;
    private boolean admin;
    private double salary;
    private String observation;
}
