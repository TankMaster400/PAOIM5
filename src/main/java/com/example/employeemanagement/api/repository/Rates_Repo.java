package com.example.employeemanagement.api.repository;

import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.entity.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Rates_Repo extends JpaRepository<Rates, Integer> {
    List<Rates> findRatesByidgEquals(Integer Idg);
}
