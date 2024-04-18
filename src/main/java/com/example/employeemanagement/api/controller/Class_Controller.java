package com.example.employeemanagement.api.controller;

import com.example.employeemanagement.api.entity.ClassEmployee;
import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.entity.Rates;
import com.example.employeemanagement.api.service.ClassService;
import com.example.employeemanagement.api.service.EmployeeService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Class")
public class Class_Controller {
    @Autowired
    private ClassService classService;

    @PostMapping("/add")
    public String addClass(@RequestBody ClassEmployee classe)
    {
        classService.addClass(classe);

        return "sucess - adding class";
    }

    @GetMapping()
    public List<ClassEmployee> getClasses()
    {
        return classService.getClasses();
    }

    @GetMapping("/get")
    public ClassEmployee getClass(@RequestParam Integer id)
    {
        return classService.getClass(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> delClass(@PathVariable Integer id)
    {
        classService.delClass(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}/employee")
    public List<Employee> getEmployees(@PathVariable Integer id)
    {
        return classService.getEmployees(id);
    }

    @GetMapping("/get/{id}/rates")
    public List<Rates> getRates(@PathVariable Integer id)
    {
        return classService.getRates(id);
    }

    @GetMapping("/get/{id}/fill")
    public String getFill(@PathVariable Integer id)
    {
        return classService.getFill(id);
    }
    @GetMapping("/csvexport")
    public void exportCSV(HttpServletResponse response) throws Exception
    {
        classService.exportCSV(response);
    }


}
