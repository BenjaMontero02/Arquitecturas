package com.arquitecturas.service.DTOs.Jugador.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JugadorRequestDTO {

    private String nombre;
    private String posicion;
    private boolean disponible;

    public JugadorRequestDTO(String nombre, String posicion, boolean disponible){
        this.nombre = nombre;
        this.posicion = posicion;
        this.disponible = disponible;
    }
}
