package org.example.DTOs;

public class DTOTable implements Comparable<DTOTable>{

    private Long e;
    private String nombre;
    private Long cantidad;

    public DTOTable(Long e, String nombre, Long cantidad){
        this.e = e;
        this.nombre = nombre;
        this.cantidad =cantidad;
    }

    public Long getE() {
        return e;
    }

    public void setE(Long e) {
        this.e = e;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DTOTable{" +
                "e=" + e +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public int compareTo(DTOTable o) {
        return o.getCantidad().compareTo(this.getCantidad());
    }
}
