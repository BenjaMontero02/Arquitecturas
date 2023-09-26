package com.arquitecturas.service.DTOs.Gol.Request;

import com.arquitecturas.domain.Gol;
import com.arquitecturas.service.DTOs.Jugador.Response.JugadorResponseDTO;

public class GolResponseDTO {

    private JugadorResponseDTO jugador;
    private Integer cantidad;

    public GolResponseDTO(Gol g){
        this.jugador = new JugadorResponseDTO(g.getJugador());
        this.cantidad = g.getCantidad();
    }
}
