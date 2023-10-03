package com.arquitecturas.service;

import com.arquitecturas.domain.Equipo;
import com.arquitecturas.domain.Jugador;
import com.arquitecturas.repository.EquipoRepository;
import com.arquitecturas.repository.JugadorRepository;
import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;

    @Transactional(readOnly = true)
    public Equipo getById(Long id) {
        Optional<Equipo> e =  this.equipoRepository.findById(id);
        if(e.isPresent()){
            return e.get();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Equipo getByNameAndTecnico(){
        Optional<Equipo> e = equipoRepository.findByNombreAndTecnico("river", "marcelo gallardo");
        if(e.isPresent()){
            return e.get();
        }else{
            return null;
        }
    }


    @Transactional
    public Long saveJugador(String nombre, JugadorRequestDTO jdto) {
        Equipo e = this.equipoRepository.findByNombre(nombre);
        e.addJugador(new Jugador(jdto.getPosicion(), jdto.getNombre(), e, jdto.isDisponible()));
        return 0L;
    }

    @Transactional
    public Long addJugador(Long id, JugadorRequestDTO jugador) {
        Optional<Equipo> e = this.equipoRepository.findById(id);
        if(e.isPresent()){
            Equipo equipo = e.get();
            Jugador j = new Jugador(jugador.getPosicion(), jugador.getNombre(), equipo, jugador.isDisponible());
            equipo.addJugador(j);
            return j.getId();
        }
        return null;
    }

    @Transactional
    public void deleteJugador(Long id, Long idJugador) {
        Optional<Equipo> e = this.equipoRepository.findById(id);
        if(e.isPresent()){
            Equipo equipo = e.get();
            Optional<Jugador> j = this.jugadorRepository.findById(idJugador);
            if(j.isPresent()){
                Jugador jugador = j.get();
                equipo.removeJugador(jugador);
            }
        }
    }
}
