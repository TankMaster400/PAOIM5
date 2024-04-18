package com.example.employeemanagement.api.repository;

import com.example.employeemanagement.api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Employee_Repo extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeeByIDgrupyEquals(Integer IDgrupy);
}
