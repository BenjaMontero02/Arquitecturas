package com.arquitecturas.domain;

import com.arquitecturas.service.DTOs.Torneo.Request.TorneoRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    private String nombre;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Grupo> grupos;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Partido> eliminaciones;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Equipo> equipos;

    public Torneo(){
        super();
    }
    public void addEliminaciones(Partido p){
        this.eliminaciones.add(p);
    }

    public void addEquipo(Equipo e){
        this.equipos.add(e);
    }

    public Torneo(TorneoRequestDTO t){
        super();
        this.nombre = t.getNombre();
        this.grupos = new ArrayList<>();
        this.eliminaciones = new ArrayList<>();
    }
    public void addGrupo(Grupo g){
        this.grupos.add(g);
    }



}
