package com.example.employeemanagement.api.service.impl;

import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.repository.Employee_Repo;
import com.example.employeemanagement.api.service.EmployeeService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Service
public class Employee_Service_impl implements EmployeeService {

    @Autowired
    private Employee_Repo employeeRepo;
    @Override
    public void addEmployee(Employee employee)
    {
        employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Employee ID" + id));
        return employee;
    }

    @Override
    public void delEmployee(Integer id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Employee ID" + id));
        employeeRepo.delete(employee);


    }

    @Override
    public List<Employee> getEmployees()
    {
        return employeeRepo.findAll();
    }

    @Override
    public void exportCSV(HttpServletResponse response) throws Exception {
        String filename = "Employee-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<Employee> writer = new StatefulBeanToCsvBuilder<Employee>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        //write all employees data to csv file
        writer.write(employeeRepo.findAll());

    }
}
