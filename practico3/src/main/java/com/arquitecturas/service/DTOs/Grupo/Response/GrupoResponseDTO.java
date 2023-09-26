package com.arquitecturas.service.DTOs.Grupo.Response;

import com.arquitecturas.domain.Grupo;
import com.arquitecturas.service.DTOs.Equipo.Response.EquipoResponseDTO;
import com.arquitecturas.service.DTOs.Partido.Response.PartidoResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GrupoResponseDTO {

    public String nombre;
    private List<PartidoResponseDTO> partidos;
    private List<EquipoResponseDTO> equipos;


    public GrupoResponseDTO(Grupo g){
        this.nombre = g.getNombre();
        this.partidos = g.getPartidos().stream()
                        .map(partido -> new PartidoResponseDTO(partido))
                        .collect(Collectors.toList());
        this.equipos = g.getEquipos().stream().map(e-> new EquipoResponseDTO(e)).collect(Collectors.toList());
    }
}
