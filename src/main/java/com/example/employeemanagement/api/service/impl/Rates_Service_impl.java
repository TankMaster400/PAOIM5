package com.example.employeemanagement.api.service.impl;

import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.entity.Rates;
import com.example.employeemanagement.api.repository.Rates_Repo;
import com.example.employeemanagement.api.service.RatesService;
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
public class Rates_Service_impl implements RatesService {

    @Autowired
    private Rates_Repo ratesRepo;
    @Override
    public void addRate(Rates rate)
    {
        ratesRepo.save(rate);
    }

    @Override
    public Rates getRate(Integer id) {
        Rates rate = ratesRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Rate ID" + id));
        return rate;
    }

    @Override
    public void delRate(Integer id) {
        Rates rate = ratesRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Rate ID" + id));
        ratesRepo.delete(rate);


    }
    @Override
    public List<Rates> getRates()
    {
        return ratesRepo.findAll();
    }

    @Override
    public void exportCSV(HttpServletResponse response) throws Exception {
        String filename = "rates-data.csv";

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        //create a csv writer
        StatefulBeanToCsv<Rates> writer = new StatefulBeanToCsvBuilder<Rates>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        //write all employees data to csv file
        writer.write(ratesRepo.findAll());

    }
}
