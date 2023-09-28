package com.arquitecturas.service.DTOs.Partido.Request;

import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import com.arquitecturas.service.DTOs.Gol.Request.GolRequestDTO;
import com.arquitecturas.service.DTOs.Punto.Request.PuntoRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

@Data
public class PartidoRequestDTO {

    @NotNull(message = "la fecha no puede ser nula")
    @NotEmpty(message = "la fecha no puede estar vacia")
    private String fecha;
    @NotNull(message = "el resultado no puede ser nulo")
    @NotEmpty(message = "el resultado no puede estar vacio")
    private String resultado;
    @NotNull(message = "el equipo local no puede ser nulo")
    @NotEmpty(message = "el equipo local no puede estar vacio")
    private String equipoA;
    @NotNull(message = "el equipo visitante no puede ser nulo")
    @NotEmpty(message = "el equipo visitante no puede estar vacio")
    private String equipoB;

    @NotNull(message = "los puntos no pueden ser nulo")
    @NotEmpty(message = "los puntos no pueden estar vacio")
    private List<PuntoRequestDTO> puntos;
    private List<GolRequestDTO> goles;

    public PartidoRequestDTO(String fecha, String resultado, String equipoA, String equipoB, List<PuntoRequestDTO> puntos, List<GolRequestDTO> goles) {
        this.fecha = fecha;
        this.resultado = resultado;
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.puntos = puntos;
        this.goles = goles;
    }
}
