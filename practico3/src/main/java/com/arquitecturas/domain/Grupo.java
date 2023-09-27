package com.arquitecturas.domain;

import com.arquitecturas.service.DTOs.Grupo.Request.GrupoRequestDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nombre;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Equipo> equipos;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Partido> partidos;

    public Grupo() {
        super();
    }

    public void addPartidos(Partido p) {
        this.partidos.add(p);
    }

    public void addEquipos(Equipo e) {
        this.equipos.add(e);
    }

    public Grupo(GrupoRequestDTO g) {
        this.nombre = g.getNombre();
        this.equipos = new ArrayList<>(4);
        this.partidos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
}
