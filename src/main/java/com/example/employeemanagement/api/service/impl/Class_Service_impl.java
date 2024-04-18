package com.example.employeemanagement.api.service.impl;

import com.example.employeemanagement.api.entity.ClassEmployee;
import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.entity.Rates;
import com.example.employeemanagement.api.repository.Class_Repo;
import com.example.employeemanagement.api.repository.Employee_Repo;
import com.example.employeemanagement.api.repository.Rates_Repo;
import com.example.employeemanagement.api.service.ClassService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class Class_Service_impl implements ClassService {

    @Autowired
    private Class_Repo classRepo;
    @Autowired
    private Employee_Repo employeeRepo;
    @Autowired
    private Rates_Repo ratesRepo;

    @Override
    public void addClass(ClassEmployee classe)
    {
        classRepo.save(classe);
    }

    @Override
    public ClassEmployee getClass(Integer id) {
        ClassEmployee classe = classRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Class ID" + id));
        return classe;
    }

    @Override
    public void delClass(Integer id) {
        ClassEmployee classe = classRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Employee ID" + id));
        classRepo.delete(classe);


    }
    @Override
    public List<ClassEmployee> getClasses()
    {
        return classRepo.findAll();
    }

    @Override
    public List<Employee> getEmployees(Integer id)
    {

        ClassEmployee classe = classRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Class ID" + id));

        return employeeRepo.findEmployeeByIDgrupyEquals(id);
    }
    @Override
    public List<Rates> getRates(Integer id)
    {
        ClassEmployee classe = classRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Class ID" + id));
        return ratesRepo.findRatesByidgEquals(id);
    }
    @Override
    public String getFill(Integer id)
    {
        ClassEmployee classe = classRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Class ID" + id));
        int val = employeeRepo.findEmployeeByIDgrupyEquals(id).size();
        double wynik = val*100./classe.getMax_p();
        return ""+wynik+"";
    }
    @Override
    public void exportCSV(HttpServletResponse response) throws Exception {
        String filename = "Class-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<ClassEmployee> writer = new StatefulBeanToCsvBuilder<ClassEmployee>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        //write all employees data to csv file
        writer.write(classRepo.findAll());

    }
}
