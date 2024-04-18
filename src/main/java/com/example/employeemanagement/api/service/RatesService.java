package com.example.employeemanagement.api.service;

import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.entity.Rates;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface RatesService {

    List<Rates> getRates();

    void addRate(Rates rate);

    Rates getRate(Integer id);

    void delRate(Integer id);
    void exportCSV(HttpServletResponse response) throws Exception;
}
