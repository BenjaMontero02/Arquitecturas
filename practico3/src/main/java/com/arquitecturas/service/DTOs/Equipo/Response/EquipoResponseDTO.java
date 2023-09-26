package com.arquitecturas.service.DTOs.Equipo.Response;

import com.arquitecturas.domain.Equipo;
import com.arquitecturas.service.DTOs.Jugador.Response.JugadorResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class EquipoResponseDTO {

    private String nombre;

    private String tecnico;

    private List<JugadorResponseDTO> jugadores;

    public EquipoResponseDTO(Equipo e){
        this.nombre = e.getNombre();
        this.tecnico = e.getTecnico();
        this.jugadores = e.getJugador().stream().map(j -> new JugadorResponseDTO(j)).collect(Collectors.toList());
    }
}
