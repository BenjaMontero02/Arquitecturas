package org.example.Entitys;

import javax.persistence.*;

@Entity
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

    public Jugador(String posicion, String nombre, Equipo e, boolean disponible){
        super();
        this.nombre = nombre;
        this.posicion = posicion;
        this.equipo = e;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", posicion='" + posicion + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}
