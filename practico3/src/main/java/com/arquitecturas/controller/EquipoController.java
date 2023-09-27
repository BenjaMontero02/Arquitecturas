package com.arquitecturas.controller;

import com.arquitecturas.domain.Equipo;
import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import com.arquitecturas.service.EquipoService;
import com.arquitecturas.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/equipo")
public class EquipoController {

    private JugadorService jugadorService;
    private EquipoService equipoService;

    @Autowired
    public EquipoController(JugadorService js, EquipoService es){
        this.jugadorService = js;
        this.equipoService = es;
    }

    @GetMapping("/{id}")
    public Equipo getEquipo(@PathVariable Long id){
        return equipoService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id){
        this.equipoService.deleteEquipo(id);
    }

    @PostMapping("/")
    public void createEquipo(@RequestBody Equipo e){
        this.equipoService.save(e);
    }

    @PatchMapping("/")
    public void updateEquipo(@RequestBody Equipo e) {
        this.equipoService.save(e);
    }

    @PostMapping("/{nombre}/saveJugador")
    public Long saveJugador(@PathVariable String nombre, @RequestBody JugadorRequestDTO jdto){
        return this.equipoService.saveJugador(nombre, jdto);
    }
}
