package com.nutrysys.nutrysys.web.dto;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Data;

@CrossOrigin
@Data
public class PacienteDTO {
    
    private String nombreCompleto;
     private LocalDateTime fechaNacimiento;
    private String estadoCivil;
    private String genero;
    private String direccion;
    private String ocupacion;
    private String telefono;
    private String correoElectronico;
    private String motivoConsulta;
   private Integer idNutriologo;

}
