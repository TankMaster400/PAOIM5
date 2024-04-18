package com.example.employeemanagement.api.controller;

import com.example.employeemanagement.api.entity.ClassEmployee;
import com.example.employeemanagement.api.entity.Employee;
import com.example.employeemanagement.api.entity.Rates;
import com.example.employeemanagement.api.service.RatesService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rates")
public class Rates_Controller {

    @Autowired
    private RatesService ratesService;

    @PostMapping("/add")
    public String addRate(@RequestBody Rates rate)
    {
        ratesService.addRate(rate);

        return "sucess - adding rate";
    }

    @GetMapping()
    public List<Rates> getRates()
    {
        return ratesService.getRates();
    }

    @GetMapping("/get")
    public Rates getRate(@RequestParam Integer id)
    {
        return ratesService.getRate(id);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> delRate(@PathVariable Integer id)
    {
        ratesService.delRate(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/csvexport")
    public void exportCSV(HttpServletResponse response) throws Exception
    {
        ratesService.exportCSV(response);
    }
}
