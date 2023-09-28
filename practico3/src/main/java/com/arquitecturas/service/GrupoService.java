package com.arquitecturas.service;

import com.arquitecturas.domain.*;
import com.arquitecturas.repository.EquipoRepository;
import com.arquitecturas.repository.GrupoRepository;
import com.arquitecturas.repository.JugadorRepository;
import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import com.arquitecturas.service.DTOs.Partido.Request.PartidoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoService {
    private GrupoRepository grupoRepository;
    private EquipoRepository equipoRepository;

    private JugadorRepository jugadorRepository;

    @Autowired
    public GrupoService(GrupoRepository grupoRepository, EquipoRepository equipoRepository, JugadorRepository jugadorRepository) {
        this.grupoRepository = grupoRepository;
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jugadorRepository;
    }


    @Transactional
    public Long addEquipo(String nombre, EquipoRequestDTO equipoRequestDTO) {
        Equipo e = equipoRepository.findByNombre(equipoRequestDTO.getNombre());
        if(e != null){
            Grupo g = grupoRepository.findByNombre(nombre);
            g.addEquipos(e);
            return e.getId();
        }
        return null;
    }

    @Transactional
    public Long addPartido(String nombre, PartidoRequestDTO e) {
        Grupo grupo = this.grupoRepository.findByNombre(nombre);
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
        grupo.addPartidos(p);
        return p.getId();
    }
}
