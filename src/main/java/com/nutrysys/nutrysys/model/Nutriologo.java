package com.nutrysys.nutrysys.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@CrossOrigin
@Data
@Entity
public class Nutriologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreCompleto;

    @DateTimeFormat (iso = ISO.DATE_TIME)
    private LocalDateTime fechaNacimiento;
    
    @DateTimeFormat (iso = ISO.DATE_TIME)
    private LocalDateTime fechaCreacion;

    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String password;
    private String cedula;
    private String nombreClinica;


    @PrePersist
    void iniCreatedAt(){
        fechaCreacion= LocalDateTime.now();
    }

    
}
