package com.arquitecturas.service.DTOs.Equipo.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class EquipoRequestDTO {

    @NotEmpty(message = "El nombre del equipo no puede ser vacio")
    @NotNull(message = "el nombre del equipo no puede ser nulo")
    private String nombre;

    @NotEmpty(message = "El nombre del tecnico no puede ser vacio")
    @NotNull(message = "el nombre del tecnico no puede ser nulo")
    private String tecnico;

    public EquipoRequestDTO(String nombre, String tecnico){
        this.nombre = nombre;
        this.tecnico = tecnico;
    }
}
