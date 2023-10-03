package com.arquitecturas.web.rest;

import com.arquitecturas.service.DTOs.Grupo.Request.GrupoRequestDTO;
import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import com.arquitecturas.service.DTOs.Partido.Request.PartidoRequestDTO;
import com.arquitecturas.service.DTOs.Torneo.Request.TorneoRequestDTO;
import com.arquitecturas.domain.Jugador;
import com.arquitecturas.domain.Torneo;
import com.arquitecturas.service.DTOs.Torneo.Response.TorneoResponseDTO;
import com.arquitecturas.service.GrupoService;
import com.arquitecturas.service.TorneoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;

import java.util.List;

@RestController
@RequestMapping("api/torneo")
@RequiredArgsConstructor
public class TorneoController {
    private final TorneoService torneoService;
    private final GrupoService grupoService;

    @GetMapping("/getAllJugadores/{id}")
    public List<Jugador> getAllJugadores(@PathVariable Long id){
        return this.torneoService.getAllJugadores(id);
    }

    @PostMapping("")
    public Long save(@RequestBody @Valid TorneoRequestDTO t){
        return this.torneoService.save(t);
    }

    @GetMapping("/getByName/{nombre}")
    public TorneoResponseDTO getTorneoByName(@PathVariable String nombre){
        return this.torneoService.getTorneoByName(nombre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.torneoService.deleteById(id);
    }
    @PostMapping("/{id}/equipo")
    public Long saveEquipo(@PathVariable Long id, @RequestBody @Valid EquipoRequestDTO e){
        return this.torneoService.saveEquipo(id, e);
    }

    @DeleteMapping("/{id}/equipo/{idEquipo}")
    public void deleteEquipo(@PathVariable Long id, @PathVariable Long idEquipo){
        this.torneoService.deleteEquipo(id, idEquipo);
    }

    @PostMapping("/{id}/partido")
    public Long saveEliminacion(@PathVariable Long id, @RequestBody @Valid PartidoRequestDTO e){
        return this.torneoService.savePartido(id, e);
    }

    @DeleteMapping("/{id}/partido/{idPartido}")
    public void deleteEliminacion(@PathVariable Long id, Long idPartido ){
        this.torneoService.deleteEliminacion(id, idPartido);
    }

    @PostMapping("/{id}/grupo")
    public Long createGrupo(@PathVariable Long id, @RequestBody @Valid GrupoRequestDTO e){
        return this.torneoService.createGrupo(id, e);
    }

    @DeleteMapping("/{id}/grupo/{idGrupo}")
    public void deleteGrupo(@PathVariable Long id, @PathVariable Long idGrupo){
        this.torneoService.deleteGrupo(id, idGrupo);
    }
}
