package org.example.Entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.PERSIST)
    private List<Jugador> jugadores;
    private String tecnico;

    public void addJugadores(Jugador j){
        this.jugadores.add(j);
    }

    public Equipo(){
        super();
    }

    public Equipo(String nombre,String tecnico){
        super();
        this.nombre = nombre;
        this.tecnico = tecnico;
        this.jugadores = new ArrayList<>();
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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public void addJugador(Jugador j ){
        this.jugadores.add(j);
    }
}
