package com.example.employeemanagement.api.service;

import com.example.employeemanagement.api.entity.Employee;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();


    void addEmployee(Employee employee);

    Employee getEmployee(Integer id);

    void delEmployee(Integer id);
    void exportCSV(HttpServletResponse response) throws Exception;
}
