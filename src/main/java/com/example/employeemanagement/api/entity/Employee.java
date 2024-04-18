package com.example.employeemanagement.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_employee;
    private String imie;
    private String nazwisko;
    private String employee_c;
    private Integer rok_urodzenia;
    private Integer wynagrodzenie;
    private Integer IDgrupy;

}
