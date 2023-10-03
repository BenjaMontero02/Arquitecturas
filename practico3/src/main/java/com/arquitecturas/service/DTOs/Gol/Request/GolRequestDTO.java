package com.arquitecturas.service.DTOs.Gol.Request;

import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GolRequestDTO {

    @NotEmpty(message = "El jugador no puede ser vacio")
    @NotNull(message = "el jugador no puede ser nulo")
    private JugadorRequestDTO jugadorRequestDTO;
    @NotEmpty(message = "El gol no puede ser vacio")
    @NotNull(message = "el gol no puede ser nulo")
    private Integer goles;

    public GolRequestDTO(JugadorRequestDTO j, Integer goles) {
        this.goles = goles;
        this.jugadorRequestDTO = j;
    }
}
