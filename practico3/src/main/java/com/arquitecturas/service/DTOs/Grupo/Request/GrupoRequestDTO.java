package com.arquitecturas.service.DTOs.Grupo.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GrupoRequestDTO {

    @NotEmpty(message = "El nombre no puede ser vacio")
    @NotNull(message = "el nombre no puede ser nulo")
    private String nombre;

    public GrupoRequestDTO(String nombre) {
        this.nombre = nombre;
    }
}
