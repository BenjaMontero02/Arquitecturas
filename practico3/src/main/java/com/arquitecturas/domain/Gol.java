package com.arquitecturas.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @ManyToOne
    private Jugador jugador;

    private Integer cantidad;

    public Gol(){
        super();
    }

    public Gol(Jugador jugador, Integer cantidad){
        super();
        this.jugador = jugador;
        this.cantidad = cantidad;
    }
}
