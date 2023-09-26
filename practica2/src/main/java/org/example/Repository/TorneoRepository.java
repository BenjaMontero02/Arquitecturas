package org.example.Repository;

import org.example.DTOs.DTOGolTable;
import org.example.DTOs.DTOTable;
import org.example.Entitys.*;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.*;

public class TorneoRepository implements CrudRepository{
    private EntityManager em;

    public TorneoRepository(){
        super();
    }

    public TorneoRepository(EntityManager em){
        super();
        this.em = em;
    }
    @Override
    public boolean create(Object obj) {
        try {
            Torneo t = (Torneo)obj;
            em.persist(t);
            return true;
        }catch (Exception exc){
            System.out.println(exc);
        }
        return false;
    }

    @Override
    public void delete(Object obj) {
        try {
            Torneo t = (Torneo)obj;
            this.em.remove(t);
        }catch (Exception exc){
            System.out.println(exc);
        }
    }

    @Override
    public Object get(Long id) {
        return this.em.find(Torneo.class, id);
    }

    @Override
    public void update(Object obj) {
        Torneo t = (Torneo)obj;
        this.em.persist(t);
    }

    public List<Jugador> getJugadoresDelTorneo(Torneo t){
        List<Jugador> jugadores = em.createQuery(
                "Select e.jugadores " +
                        "From Torneo t " +
                        "Join t.grupos g " +
                        "Join g.equipos e " +
                        "where t.id = :id")
                .setParameter("id", t.getId())
                .getResultList();

        return jugadores;
    }

    public List<DTOTable> generatedTableOfPositions(Long t, Timestamp fecha, Long gId){
        List<DTOTable> tabla =
                em.createQuery(
                "SELECT new org.example.DTOs.DTOTable(pu.ganador.id, pu.ganador.nombre, sum(pu.cantidad))" +
                "FROM Torneo t " +
                "JOIN t.grupos g " +
                        "JOIN g.partidos p " +
                "JOIN p.puntos pu " +
                "WHERE t.id = :id and p.fecha <= :fecha and g.id = :gId " +
                        "group by pu.ganador.id, pu.ganador.nombre", DTOTable.class)
                .setParameter("id", t)
                        .setParameter("fecha", fecha)
                        .setParameter("gId", gId)
                .getResultList();

        Collections.sort(tabla);
        return tabla;
    }

    public List<DTOGolTable> generatedTableOfGol(Long t, Timestamp fecha){
        List<DTOGolTable> tabla = em.createQuery(
                "Select new org.example.DTOs.DTOGolTable(g.jugador.id, g.jugador.nombre, sum(g.cantidad), g.jugador.equipo.nombre) " +
                        "FROM Torneo t " +
                        "JOIN t.grupos gr " +
                        "JOIN gr.partidos p " +
                        "JOIN p.goles g " +
                        "WHERE t.id = :id and p.fecha <= :fecha " +
                        "GROUP BY g.jugador.id, g.jugador.nombre, g.jugador.equipo.nombre")
                .setParameter("id", t)
                .setParameter("fecha", fecha)
                .getResultList();

        Collections.sort(tabla);

        return tabla;
    }
}
