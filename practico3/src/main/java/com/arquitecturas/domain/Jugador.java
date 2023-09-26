package com.arquitecturas.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String posicion;
    private boolean disponible;
    @ManyToOne
    private Equipo equipo;

    public Jugador(){
        super();
    }

    public Jugador(String position, String name, Equipo e, boolean available){
        super();
        this.nombre = name;
        this.posicion = position;
        this.equipo = e;
        this.disponible = available;
    }
}
