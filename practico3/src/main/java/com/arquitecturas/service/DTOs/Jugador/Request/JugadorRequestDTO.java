package com.arquitecturas.service.DTOs.Jugador.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JugadorRequestDTO {

    @NotNull(message = "El nombre no puedo ser nulo")
    @NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;
    @NotNull(message = "la posicion no puedo ser nulo")
    @NotEmpty(message = "la posicion no puede ser vacio")
    private String posicion;
    @NotNull(message = "Su disponibilidad no puedo ser nulo")
    @NotEmpty(message = "su disponibilidad no puede ser vacio")
    private boolean disponible;

    public JugadorRequestDTO(String nombre, String posicion, boolean disponible){
        this.nombre = nombre;
        this.posicion = posicion;
        this.disponible = disponible;
    }
}
