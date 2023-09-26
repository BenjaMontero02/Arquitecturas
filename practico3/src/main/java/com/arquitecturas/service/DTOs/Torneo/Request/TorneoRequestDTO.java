package com.arquitecturas.service.DTOs.Torneo.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TorneoRequestDTO {

    @NotNull(message = "el nombre del torneo no puede ser nulo")
    @NotEmpty(message = "el nomre del torneo no puede estar vacio")
    private String nombre;

    public TorneoRequestDTO(){}
    public TorneoRequestDTO(String nombre){
        this.nombre =nombre;
    }
}
