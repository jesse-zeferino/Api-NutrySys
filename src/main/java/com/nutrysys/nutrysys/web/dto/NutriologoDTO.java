package com.nutrysys.nutrysys.web.dto;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Data;

@CrossOrigin
@Data
public class NutriologoDTO {
  
    private String nombreCompleto;
    private LocalDateTime fechaNacimiento;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String password;
    private String cedula;
    private String nombreClinica;
}
 