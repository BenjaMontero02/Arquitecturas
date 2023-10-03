package com.arquitecturas.web.rest;

import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import com.arquitecturas.service.DTOs.Partido.Request.PartidoRequestDTO;
import com.arquitecturas.service.GrupoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grupo")
@RequiredArgsConstructor
public class GrupoController {

    private GrupoService grupoService;

    @PostMapping("/{id}/addEquipo")
    public Long addEquipo(@PathVariable Long id, @RequestBody @Valid EquipoRequestDTO equipoRequestDTO){
        return this.grupoService.addEquipo(id, equipoRequestDTO);
    }

    @DeleteMapping("/{id}/deleteEqipo/{idEquipo}")
    public void deleteEquipo(@PathVariable Long id, @PathVariable Long idEquipo){
        this.grupoService.deleteEquipo(id, idEquipo);
    }


    @PostMapping("/{id}/addPartido")
    public Long addPartido(@PathVariable Long id, @RequestBody @Valid PartidoRequestDTO p){
        return this.grupoService.addPartido(id, p);
    }

    @DeleteMapping("/{id}/deletePartido/{idPartido}")
    public void deletePartido(@PathVariable Long id, Long idPartido){
        this.grupoService.deletePartido(id, idPartido);
    }

}
