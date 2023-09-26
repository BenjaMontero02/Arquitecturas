package org.example.Entitys;

import javax.persistence.*;

@Entity
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

    @Override
    public String toString() {
        return "Gol{" +
                "id=" + id +
                ", jugador=" + jugador +
                ", cantidad=" + cantidad +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
