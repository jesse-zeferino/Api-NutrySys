package com.nutrysys.nutrysys.web.dto;
import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.Data;

@CrossOrigin
@Data
public class VerdurasDTO {
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
