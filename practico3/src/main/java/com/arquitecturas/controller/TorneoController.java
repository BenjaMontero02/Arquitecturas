package com.arquitecturas.controller;

import com.arquitecturas.service.DTOs.Torneo.Request.TorneoRequestDTO;
import com.arquitecturas.domain.Jugador;
import com.arquitecturas.domain.Torneo;
import com.arquitecturas.service.TorneoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/torneo")
public class TorneoController {
    private TorneoService torneoService;

    public TorneoController(TorneoService ts){
        this.torneoService = ts;
    }

    @GetMapping("/getAllJugadores/{id}")
    public List<Jugador> getAllJugadores(@PathVariable Long id){
        return this.torneoService.getAllJugadores(id);
    }

    @PostMapping("")
    public Long save(@RequestBody TorneoRequestDTO t){
        return this.torneoService.save(t);
    }

    @GetMapping("/getByName/{nombre}")
    public Torneo getTorneoByName(@PathVariable String nombre){
        return this.torneoService.getTorneoByName(nombre);
    }

    @GetMapping("/hola")
    public String hola(){
        return "hooolaa";
    }
}
