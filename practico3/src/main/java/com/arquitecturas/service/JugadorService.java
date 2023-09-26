package com.arquitecturas.service;

import com.arquitecturas.domain.Jugador;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.arquitecturas.repository.JugadorRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JugadorService {
    private JugadorRepository jugadorRepository;

    public void save(Jugador j){
        this.jugadorRepository.save(j);
    }

    public void delete(Long id){
        this.jugadorRepository.deleteById(id);
    }

    public Jugador getById(Long id){
        Optional<Jugador> jugador = this.jugadorRepository.findById(id);
        if(jugador.isPresent()){
            return jugador.get();
        }
        return null;
    }
}
