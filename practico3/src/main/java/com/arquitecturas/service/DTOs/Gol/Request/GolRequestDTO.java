package com.arquitecturas.service.DTOs.Gol.Request;

import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import lombok.Data;

@Data
public class GolRequestDTO {

    private JugadorRequestDTO jugadorRequestDTO;
    private Integer goles;

    public GolRequestDTO(JugadorRequestDTO j, Integer goles) {
        this.goles = goles;
        this.jugadorRequestDTO = j;
    }
}
