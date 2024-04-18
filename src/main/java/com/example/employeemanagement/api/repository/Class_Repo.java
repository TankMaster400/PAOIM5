package com.example.employeemanagement.api.repository;

import com.example.employeemanagement.api.entity.ClassEmployee;
import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.entity.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Class_Repo extends JpaRepository<ClassEmployee, Integer> {




}
