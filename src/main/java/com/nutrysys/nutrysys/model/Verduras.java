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

public class Verduras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String cantidadSugerida;
    private String unidad;
    private Float pesoBruto;
    private Float pesoNeto;
    private Float energia;
    private Float proteina;
    private Float lipidos;
    private Float hidratosCarbono;
    private Float fibra;
    private Float vitaminaA;
    private Float acidoAscorbico;
    private Float acidoFolico;
    private Float hierro;
    private Float potasio;
    private Float indiceGlicemico;
    private Float cargaGlicemica;
}

