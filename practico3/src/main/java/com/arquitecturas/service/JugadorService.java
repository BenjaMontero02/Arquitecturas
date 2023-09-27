package com.arquitecturas.service;

import com.arquitecturas.domain.Jugador;
import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import com.arquitecturas.service.DTOs.Jugador.Response.JugadorResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.arquitecturas.repository.JugadorRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JugadorService {
    private JugadorRepository jugadorRepository;

    @Transactional
    public void delete(Long id){
        this.jugadorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public JugadorResponseDTO getById(Long id){
        Optional<Jugador> jugador = this.jugadorRepository.findById(id);
        if(jugador.isPresent()){
            return new JugadorResponseDTO(jugador.get());
        }
        return null;
    }

    @Transactional
    public boolean putJugador(String nombre, JugadorRequestDTO jdto){
        Jugador jugador = this.jugadorRepository.findByNombre(nombre);
        jugador.setDisponible(jdto.isDisponible());
        jugador.setNombre(jdto.getNombre());
        jugador.setPosicion(jdto.getPosicion());
        this.jugadorRepository.save(jugador);
        return true;
    }
}
