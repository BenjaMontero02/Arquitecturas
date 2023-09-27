package com.arquitecturas.service;

import com.arquitecturas.domain.Equipo;
import com.arquitecturas.domain.Grupo;
import com.arquitecturas.repository.EquipoRepository;
import com.arquitecturas.repository.GrupoRepository;
import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {
    private GrupoRepository grupoRepository;
    private EquipoRepository equipoRepository;


    public Long addEquipo(String nombre, EquipoRequestDTO equipoRequestDTO) {
        Equipo e = equipoRepository.findByNombre(equipoRequestDTO.getNombre());
        if(e != null){
            Grupo g = grupoRepository.findByNombre(nombre);
            g.addEquipos(e);
            return e.getId();
        }
        return null;
    }
}
