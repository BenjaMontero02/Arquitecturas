package org.example.Entitys;

import javax.persistence.*;

@Entity
public class Punto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Equipo ganador;

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
