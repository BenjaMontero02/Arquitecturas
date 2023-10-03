package com.arquitecturas.service.DTOs.Gol.Response;

import com.arquitecturas.domain.Gol;
import com.arquitecturas.service.DTOs.Jugador.Response.JugadorResponseDTO;

public class GolResponseDTO {

    private Long id;
    private JugadorResponseDTO jugador;
    private Integer cantidad;

    public GolResponseDTO(Gol g){
        this.id = g.getId();
        this.jugador = new JugadorResponseDTO(g.getJugador());
        this.cantidad = g.getCantidad();
    }
}
