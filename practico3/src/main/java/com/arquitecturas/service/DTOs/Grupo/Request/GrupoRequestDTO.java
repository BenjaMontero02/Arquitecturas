package com.arquitecturas.service.DTOs.Grupo.Request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GrupoRequestDTO {

    private String nombre;

    public GrupoRequestDTO(String nombre) {
        this.nombre = nombre;
    }
}
