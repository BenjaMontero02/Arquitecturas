package com.arquitecturas.service.DTOs.Partido.Response;

import com.arquitecturas.domain.Partido;
import com.arquitecturas.service.DTOs.Equipo.Response.EquipoResponseDTO;
import com.arquitecturas.service.DTOs.Gol.Response.GolResponseDTO;
import com.arquitecturas.service.DTOs.Punto.Response.PuntoResponseDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class PartidoResponseDTO {

    private Long id;
    private Timestamp fecha;
    private String resultado;
    private EquipoResponseDTO local;
    private EquipoResponseDTO visitante;
    private List<GolResponseDTO> goles;

    private List<PuntoResponseDTO> puntos;

    public PartidoResponseDTO(Partido p) {
        this.id = p.getId();
        this.fecha = p.getFecha();
        this.resultado = p.getResultado();
        this.local = new EquipoResponseDTO(p.getEquipoA());
        this.visitante = new EquipoResponseDTO(p.getEquipoB());
        this.goles = p.getGoles().stream()
                     .map(gol -> new GolResponseDTO(gol))
                .collect(Collectors.toList());
        this.puntos = p.getPuntos().stream().map((p1 -> new PuntoResponseDTO(p1))).collect(Collectors.toList());
    }
}
