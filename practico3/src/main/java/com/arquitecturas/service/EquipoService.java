package com.arquitecturas.service;

import com.arquitecturas.domain.Equipo;
import com.arquitecturas.domain.Jugador;
import com.arquitecturas.repository.EquipoRepository;
import com.arquitecturas.service.DTOs.Jugador.Request.JugadorRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipoService {

    private EquipoRepository equipoRepository;

    public Equipo getById(Long id) {
        Optional<Equipo> e =  this.equipoRepository.findById(id);
        if(e.isPresent()){
            return e.get();
        }
        return null;
    }

    public Equipo getByNameAndTecnico(){
        Optional<Equipo> e = equipoRepository.findByNombreAndTecnico("river", "marcelo gallardo");
        if(e.isPresent()){
            return e.get();
        }else{
            return null;
        }
    }

    public void deleteEquipo(Long id) {
        this.equipoRepository.deleteById(id);
    }

    public void save(Equipo e) {
        this.equipoRepository.save(e);
    }

    @Transactional
    public Long saveJugador(String nombre, JugadorRequestDTO jdto) {
        Equipo e = this.equipoRepository.findByNombre(nombre);
        e.addJugador(new Jugador(jdto.getPosicion(), jdto.getNombre(), e, jdto.isDisponible()));
        return 0L;
    }
}
