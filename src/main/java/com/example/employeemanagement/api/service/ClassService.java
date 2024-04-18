package com.example.employeemanagement.api.service;

import com.example.employeemanagement.api.entity.ClassEmployee;
import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.entity.Rates;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface ClassService {

    List<ClassEmployee> getClasses();

    void addClass(ClassEmployee classe);

    ClassEmployee getClass(Integer id);

    void delClass(Integer id);

    List<Employee> getEmployees(Integer id);
    List<Rates> getRates(Integer id);
    String getFill(Integer id);
    void exportCSV(HttpServletResponse response) throws Exception;

}
