package com.arquitecturas.web.rest;

import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import com.arquitecturas.service.EquipoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    private EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping("/{id}/addJugador")
    public Long addJugador(@PathVariable Long id, @RequestBody @Valid JugadorRequestDTO jugador) {
        return this.equipoService.addJugador(id, jugador);
    }

    @DeleteMapping("/{id}/deleteJugador/{idJugador}")
    public void deleteJugador(@PathVariable Long id, @PathVariable Long idJugador) {
        this.equipoService.deleteJugador(id, idJugador);
    }
}
