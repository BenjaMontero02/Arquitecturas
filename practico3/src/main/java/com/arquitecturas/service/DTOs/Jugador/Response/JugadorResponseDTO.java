package com.arquitecturas.service.DTOs.Jugador.Response;

import com.arquitecturas.domain.Jugador;
import com.arquitecturas.service.DTOs.Equipo.Response.EquipoResponseDTO;

public class JugadorResponseDTO {

    private String nombre;
    private String posicion;
    private boolean disponible;
    private EquipoResponseDTO equipo;

    public JugadorResponseDTO(Jugador j){
        this.nombre = j.getNombre();
        this.posicion = j.getPosicion();
        this.disponible = j.isDisponible();
        this.equipo = new EquipoResponseDTO(j.getEquipo());
    }
}
