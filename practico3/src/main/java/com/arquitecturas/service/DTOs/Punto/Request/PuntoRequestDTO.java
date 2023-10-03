package com.arquitecturas.service.DTOs.Punto.Request;

import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PuntoRequestDTO {

    @NotNull(message = "el equipo no puede ser nulo")
    @NotEmpty(message = "el equipo no puede estar vacio")
    private String equipo;
    @NotNull(message = "el equipo ganador no puede ser nulo")
    @NotEmpty(message = "el equipo ganador no puede estar vacio")
    private EquipoRequestDTO ganador;
    @NotNull(message = "la cantidad no puede ser nula")
    @NotEmpty(message = "la cantidad no puede estar vacia")
    private Integer cantidad;

    public PuntoRequestDTO(EquipoRequestDTO ganador, Integer cantidad) {
        this.ganador = ganador;
        this.cantidad = cantidad;
    }
}
