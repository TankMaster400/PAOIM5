package com.example.employeemanagement.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_r;
    private Integer Ocena;
    private Integer idg;
    private java.sql.Date data;
    private String komentarz;
}
