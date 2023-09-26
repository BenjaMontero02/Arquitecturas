package org.example.Entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.example.Entitys.Jugador;

@Entity
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Grupo> grupos;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Partido> eliminaciones;
    public Torneo(){
        super();
    }

    public void addEliminacion(Partido p){
        this.eliminaciones.add(p);
    }

    public Torneo(String nombre){
        super();
        this.nombre =nombre;
        this.grupos = new ArrayList<>();
        this.eliminaciones = new ArrayList<>();
    }

    public void addGrupo(Grupo g){
        this.grupos.add(g);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Partido> getEliminaciones() {
        return eliminaciones;
    }

    public void setEliminaciones(List<Partido> eliminaciones) {
        this.eliminaciones = eliminaciones;
    }
}
