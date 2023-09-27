package com.arquitecturas.service;
import com.arquitecturas.repository.EquipoRepository;
import com.arquitecturas.repository.GrupoRepository;
import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import com.arquitecturas.service.DTOs.Grupo.Request.GrupoRequestDTO;
import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import com.arquitecturas.service.DTOs.Torneo.Request.TorneoRequestDTO;
import com.arquitecturas.domain.*;

import com.arquitecturas.repository.TorneoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TorneoService {
    private TorneoRepository torneoRepository;
    private GrupoRepository grupoRepository;
    private EquipoRepository equipoRepository;

    public Torneo getTorneoByName(String s){
        return this.torneoRepository.findByNombre(s);
    }

    @Transactional
    public Long save(TorneoRequestDTO t){
        Torneo torneo = new Torneo(t);
        Torneo t1 = this.torneoRepository.save(torneo);
        return t1.getId();
    }

    public Long saveEquipo(String nombreTorneo, EquipoRequestDTO e){
        Torneo t = this.getTorneoByName(nombreTorneo);
        if(t != null){
            //preguntar si esta bien
            t.addEquipo(new Equipo(e));
            return 1L;
        }

        return 0L;
    }

    @org.springframework.transaction.annotation.Transactional( readOnly = true )
    public List<Jugador> getAllJugadores(Long id) {
        Optional<Torneo> t = this.torneoRepository.findById(id);
        if(t.isPresent()){
            Torneo torneo = t.get();
            System.out.println(torneo);
            List<Equipo> equipos = torneo.getEquipos();
            List<Jugador> jugadors = new ArrayList<>();
            for (Equipo e: equipos) {
                jugadors.addAll(e.getJugador());
            }
            return jugadors;
        }else{
            return null;
        }
    }

    public Long createGrupo(String nombre, GrupoRequestDTO e) {
        Torneo torneo = this.getTorneoByName(nombre);
        if(torneo!= null){
            torneo.addGrupo(new Grupo(e));
            return 1L;
        }
        return 0L;
    }
}
