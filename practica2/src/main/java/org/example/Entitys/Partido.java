package org.example.Entitys;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Timestamp fecha;
    private String resultado;
    @OneToOne
    private Equipo equipoA;
    @OneToOne
    private Equipo equipoB;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Punto> puntos;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Gol> goles;

    public Partido(){
        super();
    }

    public void addPunto(Punto p){
        this.puntos.add(p);
    }

    public void addGol(Gol g){
        this.goles.add(g);
    }


    public Partido(Timestamp fecha, String resultado, Equipo a, Equipo b){
        super();
        this.resultado = resultado;
        this.equipoA = a;
        this.equipoB = b;
        this.fecha = fecha;
        this.puntos = new ArrayList<>();
        this.goles = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Equipo getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public List<Gol> getGoles() {
        return goles;
    }

    public void setGoles(List<Gol> goles) {
        this.goles = goles;
    }

    public List<Punto> getPuntos() {
        return puntos;
    }

    public void setPuntos(List<Punto> puntos) {
        this.puntos = puntos;
    }
}
