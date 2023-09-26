package org.example.DTOs;

public class DTOGolTable implements Comparable<DTOGolTable>{

    private Long id;
    private String nombre;
    private Long goles;

    private String nombreEquipo;

    public DTOGolTable(Long id, String nombre, Long gol, String nombreEquipo){
        this.id = id;
        this.nombre = nombre;
        this.goles = gol;
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
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

    public Long getGoles() {
        return goles;
    }

    public void setGoles(Long goles) {
        this.goles = goles;
    }

    @Override
    public String toString() {
        return "DTOGolTable{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", goles=" + goles +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                '}';
    }

    @Override
    public int compareTo(DTOGolTable o) {
        return o.getGoles().compareTo(this.goles);
    }
}
