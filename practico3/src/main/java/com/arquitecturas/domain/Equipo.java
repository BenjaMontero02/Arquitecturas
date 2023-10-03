package com.arquitecturas.domain;

import com.arquitecturas.service.DTOs.Equipo.Request.EquipoRequestDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.PERSIST)
    private List<Jugador> jugador;

    private String tecnico;

    public void addJugador(Jugador j){
        this.jugador.add(j);
    }

    public Equipo(){
        super();
    }

    public Equipo(EquipoRequestDTO e){
        super();
        this.nombre = e.getNombre();
        this.tecnico = e.getTecnico();
        this.jugador = new ArrayList<>();
    }

    public void removeJugador(Jugador jugador) {
        this.jugador.remove(jugador);
    }
}
