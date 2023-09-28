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
import org.springframework.web.bind.annotation.*;
import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;

import java.util.List;

@RestController
@RequestMapping("api/torneo")
public class TorneoController {
    private TorneoService torneoService;
    private GrupoService grupoService;

    public TorneoController(TorneoService ts, GrupoService gs){
        this.torneoService = ts;
        this.grupoService = gs;
    }

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

    @GetMapping("/hola")
    public String hola(){
        return "hooolaa";
    }

    @PostMapping("/{nombre}/saveEquipo")
    public Long saveEquipo(@PathVariable String nombre, @RequestBody EquipoRequestDTO e){
        return this.torneoService.saveEquipo(nombre, e);
    }

    @PostMapping("/{nombre}/savePartido")
    public Long saveEliminacion(@PathVariable String nombre, @RequestBody PartidoRequestDTO e){
        return this.torneoService.savePartido(nombre, e);
    }

    @PostMapping("/{nombre}/saveGrupo")
    public Long createGrupo(@PathVariable String nombre, @RequestBody GrupoRequestDTO e){
        return this.torneoService.createGrupo(nombre, e);
    }
}
