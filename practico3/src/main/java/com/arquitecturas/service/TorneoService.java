package com.arquitecturas.service;
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

    public Torneo getTorneoByName(String s){
        return this.torneoRepository.findByNombre(s);
    }

    @Transactional
    public Long save(TorneoRequestDTO t){
        Torneo torneo = new Torneo(t.getNombre());
        Torneo t1 = this.torneoRepository.save(torneo);
        return t1.getId();
    }

    @org.springframework.transaction.annotation.Transactional( readOnly = true )
    public List<Jugador> getAllJugadores(Long id) {
        Optional<Torneo> t = this.torneoRepository.findById(id);
        if(t.isPresent()){
            Torneo torneo = t.get();
            System.out.println(torneo);
            List<Equipo> equipos = torneo.getTeams();
            List<Jugador> jugadors = new ArrayList<>();
            for (Equipo e: equipos) {
                jugadors.addAll(e.getJugador());
            }
            return jugadors;
        }else{
            return null;
        }
    }
}
