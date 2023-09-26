package com.arquitecturas.domain;

import jakarta.persistence.*;

@Entity
public class Punto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    private Equipo ganador;

    @Column
    private Integer cantidad;

    public Punto(){
        super();
    }

    public Punto(Equipo ganador, Integer cantidad){
        super();
        this.ganador = ganador;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public Equipo getGanador() {
        return ganador;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
