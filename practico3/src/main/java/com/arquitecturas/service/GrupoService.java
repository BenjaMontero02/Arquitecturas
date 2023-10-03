package com.arquitecturas.service;

import com.arquitecturas.domain.*;
import com.arquitecturas.repository.EquipoRepository;
import com.arquitecturas.repository.GrupoRepository;
import com.arquitecturas.repository.JugadorRepository;
import com.arquitecturas.repository.PartidoRepository;
import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import com.arquitecturas.service.DTOs.Partido.Request.PartidoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GrupoService {
    private final GrupoRepository grupoRepository;
    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;
    private final PartidoRepository partidoRepository;

    @Transactional
    public Long addEquipo(Long id, EquipoRequestDTO equipoRequestDTO) {
        Equipo e = equipoRepository.findByNombre(equipoRequestDTO.getNombre());
        if(e != null){
            Optional<Grupo> g = grupoRepository.findById(id);
            if(g.isPresent()){
                g.get().getEquipos().add(e);
                return e.getId();
            }
            return null;
        }
        return null;
    }

    @Transactional
    public Long addPartido(Long id, PartidoRequestDTO e) {
        Optional<Grupo> grupo = this.grupoRepository.findById(id);
        if(grupo.isPresent()){
            Grupo grupo1 = grupo.get();
        Equipo a = this.equipoRepository.findByNombre(e.getEquipoA());
        Equipo b = this.equipoRepository.findByNombre(e.getEquipoB());
        Partido p = new Partido();
        p.setEquipoA(a);
        p.setEquipoB(b);
        p.setFecha(Timestamp.valueOf(e.getFecha()));
        p.setResultado(e.getResultado());

        if(a!=null && b!=null){
            List<Punto> puntos = e.getPuntos()
                    .stream()
                    .map(pu -> {
                        //creo un punto pero como me llega un equipoRequest, tengo que ir a buscarlo
                        //para no hacer doble query que lo busque, comparo los nombres de ambos equipos
                        Punto p1 = new Punto();
                        p1.setCantidad(pu.getCantidad());
                        if(pu.getGanador().getNombre().equals(b.getNombre())){
                            p1.setGanador(b);
                        }else{
                            p1.setGanador(a);
                        }
                        return p1;
                    }).collect(Collectors.toList());

            p.setPuntos(puntos);

            List<Gol> goles = e.getGoles().stream().map(g -> {
                //me traigo la instancia del juegador, pero como me llega en request el gol
                //el jugador x logica deberia llegar x request tambien
                Jugador j = this.jugadorRepository.findByNombre(g.getJugadorRequestDTO().getNombre());
                Gol g1 = new Gol(j, g.getGoles());
                return g1;
            }).collect(Collectors.toList());

            p.setGoles(goles);
        }
        grupo1.addPartidos(p);
        return p.getId();
        }
        return null;
    }

    @Transactional
    public void deletePartido(Long id, Long idPartido) {
        Optional<Grupo> g = this.grupoRepository.findById(id);
        if(g.isPresent()){
            Optional<Partido> p = this.partidoRepository.findById(idPartido);
            if(p.isPresent()){
                g.get().removePartido(p.get());
            }
        }
    }

    @Transactional
    public void deleteEquipo(Long id, Long idEquipo) {
        Optional<Grupo> g = this.grupoRepository.findById(id);

        if(g.isPresent()){
            Optional<Equipo> e = this.equipoRepository.findById(idEquipo);
            if(e.isPresent()){
                g.get().removeEquipo(e.get());
            }
        }

    }
}
