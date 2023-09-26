package com.arquitecturas.service.DTOs.Partido.Response;

import com.arquitecturas.domain.Equipo;
import com.arquitecturas.domain.Gol;
import com.arquitecturas.domain.Partido;
import com.arquitecturas.service.DTOs.Equipo.Response.EquipoResponseDTO;
import com.arquitecturas.service.DTOs.Gol.Request.GolResponseDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class PartidoResponseDTO {

    private Timestamp fecha;
    private String resultado;
    private EquipoResponseDTO local;
    private EquipoResponseDTO visitante;
    private List<GolResponseDTO> goles;

    public PartidoResponseDTO(Partido p) {
        this.fecha = p.getFecha();
        this.resultado = p.getResultado();
        this.local = new EquipoResponseDTO(p.getEquipoA());
        this.visitante = new EquipoResponseDTO(p.getEquipoB());
        this.goles = p.getGoles().stream()
                     .map(gol -> new GolResponseDTO(gol))
                .collect(Collectors.toList());
    }
}
