package com.arquitecturas.service;
import com.arquitecturas.repository.EquipoRepository;
import com.arquitecturas.repository.GrupoRepository;
import com.arquitecturas.repository.JugadorRepository;
import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import com.arquitecturas.service.DTOs.Grupo.Request.GrupoRequestDTO;
import com.arquitecturas.service.DTOs.Partido.Request.PartidoRequestDTO;
import com.arquitecturas.service.DTOs.Torneo.Request.TorneoRequestDTO;
import com.arquitecturas.domain.*;

import com.arquitecturas.repository.TorneoRepository;
import com.arquitecturas.service.DTOs.Torneo.Response.TorneoResponseDTO;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TorneoService {
    private TorneoRepository torneoRepository;
    private GrupoRepository grupoRepository;
    private JugadorRepository jugadorRepository;
    private EquipoRepository equipoRepository;

    @Autowired
    public TorneoService(TorneoRepository torneoRepository, GrupoRepository grupoRepository, EquipoRepository equipoRepository, JugadorRepository jug) {
        this.torneoRepository = torneoRepository;
        this.grupoRepository = grupoRepository;
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jug;
    }

    @Transactional(readOnly = true)
    public TorneoResponseDTO getTorneoByName(String s){
        Torneo t = this.torneoRepository.findByNombre(s);
        return new TorneoResponseDTO(t);
    }

    @Transactional
    public Long save(TorneoRequestDTO t){
        Torneo torneo = new Torneo(t);
        Torneo t1 = this.torneoRepository.save(torneo);
        return t1.getId();
    }

    @Transactional
    public Long saveEquipo(String nombreTorneo, EquipoRequestDTO e){
        Torneo t = this.torneoRepository.findByNombre(nombreTorneo);
        if(t != null){
            //preguntar si esta bien
            Equipo equipo = new Equipo(e);
            t.addEquipo(equipo);
            return equipo.getId();
        }

        return null;
    }

    @Transactional( readOnly = true )
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

    @Transactional
    public Long createGrupo(String nombre, GrupoRequestDTO e) {
        Torneo torneo = this.torneoRepository.findByNombre(nombre);
        if(torneo!= null){
            Grupo gr = new Grupo(e);
            torneo.addGrupo(gr);
            return gr.getId();
        }
        return null;
    }

    @Transactional
    public Long savePartido(String nombre, PartidoRequestDTO e) {
        Torneo t = this.torneoRepository.findByNombre(nombre);
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
        t.addEliminaciones(p);
        return p.getId();
    }
}
