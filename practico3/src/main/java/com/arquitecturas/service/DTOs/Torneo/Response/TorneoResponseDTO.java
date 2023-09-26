package com.arquitecturas.service.DTOs.Torneo.Response;

import com.arquitecturas.domain.Grupo;
import com.arquitecturas.domain.Torneo;
import com.arquitecturas.service.DTOs.Equipo.Response.EquipoResponseDTO;
import com.arquitecturas.service.DTOs.Grupo.Response.GrupoResponseDTO;
import com.arquitecturas.service.DTOs.Partido.Response.PartidoResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TorneoResponseDTO {

    private String nombre;
    private List<GrupoResponseDTO> grupos;
    private List<PartidoResponseDTO> eliminaciones;
    private List<EquipoResponseDTO> equipos;

    public TorneoResponseDTO(Torneo t){
        this.nombre = t.getNombre();
        this.grupos = t.getGrupos().stream().map(g->new GrupoResponseDTO(g)).collect(Collectors.toList());
        this.eliminaciones = t.getEliminaciones().stream().map(p-> new PartidoResponseDTO(p)).collect(Collectors.toList());
        this.equipos = t.getEquipos().stream().map(e-> new EquipoResponseDTO(e)).collect(Collectors.toList());
    }
}
