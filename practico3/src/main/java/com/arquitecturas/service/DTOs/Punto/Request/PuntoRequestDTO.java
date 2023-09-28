package com.arquitecturas.service.DTOs.Punto.Request;

import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import lombok.Data;

@Data
public class PuntoRequestDTO {

    private EquipoRequestDTO ganador;
    private Integer cantidad;

    public PuntoRequestDTO(EquipoRequestDTO ganador, Integer cantidad) {
        this.ganador = ganador;
        this.cantidad = cantidad;
    }
}
