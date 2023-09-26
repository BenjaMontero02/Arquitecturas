package org.example.Entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Equipo> equipos;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Partido>partidos;

    public Grupo(){
        super();
    }

    public void addPartido(Partido p){
        this.partidos.add(p);
    }

    public void addEquipo(Equipo e){
        this.equipos.add(e);
    }

    public Grupo(String nombre){
        this.nombre = nombre;
        this.equipos = new ArrayList<>(4);
        this.partidos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", equipos=" + equipos +
                ", partidos=" + partidos +
                '}';
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
