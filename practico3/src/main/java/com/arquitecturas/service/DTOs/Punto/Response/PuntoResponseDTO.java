package com.arquitecturas.service.DTOs.Punto.Response;

import com.arquitecturas.domain.Partido;
import com.arquitecturas.domain.Punto;
import com.arquitecturas.service.DTOs.Equipo.Response.EquipoResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class PuntoResponseDTO {

    private Long id;
    private EquipoResponseDTO ganador;
    private Integer cantidad;
    public PuntoResponseDTO(Punto p){
        this.id = p.getId();
        this.cantidad = p.getCantidad();
        this.ganador = new EquipoResponseDTO(p.getGanador());
    }
}
