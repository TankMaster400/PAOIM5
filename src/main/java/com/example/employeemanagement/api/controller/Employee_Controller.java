package com.example.employeemanagement.api.controller;

import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class Employee_Controller {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee)
    {
        employeeService.addEmployee(employee);

        return "sucess - adding Employee";
    }

    @GetMapping()
    public List<Employee> getEmployees()
    {
        return employeeService.getEmployees();
    }
    @GetMapping("/get")
    public Employee getEmployee(@RequestParam Integer id)
    {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> delEmployee(@PathVariable Integer id)
    {
        employeeService.delEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/csvexport")
    public void exportCSV(HttpServletResponse response) throws Exception
    {
    employeeService.exportCSV(response);
    }
}
