package com.arquitecturas.web.rest;

import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import com.arquitecturas.service.EquipoService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    private EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping("/{nombre}/addJugador")
    public Long addJugador(@PathVariable String nombre, @RequestBody JugadorRequestDTO jugador) {
        return this.equipoService.addJugador(nombre, jugador);
    }
}
