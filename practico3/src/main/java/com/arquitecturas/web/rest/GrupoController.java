package com.arquitecturas.web.rest;

import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import com.arquitecturas.service.GrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grupo")
@RequiredArgsConstructor
public class GrupoController {

    private GrupoService grupoService;

    @PostMapping("/{nombre}/addEquipo")
    public Long addEquipo(@PathVariable String nombre, @RequestBody EquipoRequestDTO equipoRequestDTO){
        return this.grupoService.addEquipo(nombre, equipoRequestDTO);
    }

}
